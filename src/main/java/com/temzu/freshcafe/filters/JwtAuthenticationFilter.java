package com.temzu.freshcafe.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.temzu.freshcafe.entities.UserInfo;
import com.temzu.freshcafe.exceptions.MarketError;
import com.temzu.freshcafe.exceptions.TokenExpiredException;
import com.temzu.freshcafe.services.RedisService;
import com.temzu.freshcafe.services.TokenService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final RedisService<String> redisService;

  @SneakyThrows
  @Override
  protected void doFilterInternal(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      FilterChain filterChain) {
    String token = httpServletRequest.getHeader("Authorization");

    if (authorizationHeaderIsInvalid(token)) {
      filterChain.doFilter(httpServletRequest, httpServletResponse);
      return;
    }

    token = token.substring(7);

    UserInfo userInfo = tokenService.parseToken(token);
    String key = userInfo.getUserLogin().concat("_token");
    if (!redisService.exists(key) || !redisService.get(key).equals(token)) {
      httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
      ObjectMapper mapper = new ObjectMapper();
      httpServletResponse.setContentType("application/json");
      httpServletResponse
          .getWriter()
          .write(
              mapper.writeValueAsString(
                  new MarketError(new TokenExpiredException(token).getMessage())));
    } else {
      UsernamePasswordAuthenticationToken authenticationToken = createToken(token);

      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
  }

  private boolean authorizationHeaderIsInvalid(String authorizationHeader) {
    return authorizationHeader == null || !authorizationHeader.startsWith("Bearer ");
  }

  private UsernamePasswordAuthenticationToken createToken(String token) {
    UserInfo userInfo = tokenService.parseToken(token);

    List<GrantedAuthority> authorities = new ArrayList<>();

    if (userInfo.getRoles() != null && !userInfo.getRoles().isEmpty()) {
      authorities.addAll(
          userInfo.getRoles().stream()
              .map(SimpleGrantedAuthority::new)
              .collect(Collectors.toList()));
    }

    return new UsernamePasswordAuthenticationToken(userInfo.getUserLogin(), null, authorities);
  }
}
