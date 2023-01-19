package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.UserDao;
import com.temzu.freshcafe.dtos.AuthRequestDto;
import com.temzu.freshcafe.dtos.AuthResponseDto;
import com.temzu.freshcafe.dtos.SignUpRequestDto;
import com.temzu.freshcafe.entities.Role;
import com.temzu.freshcafe.entities.User;
import com.temzu.freshcafe.entities.UserInfo;
import com.temzu.freshcafe.mappers.UserMapper;
import com.temzu.freshcafe.services.AuthService;
import com.temzu.freshcafe.services.TokenService;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserDao userDao;
  private final TokenService tokenService;
  private final UserMapper userMapper;

  @Transactional
  @Override
  public AuthResponseDto signUp(SignUpRequestDto signUpRequestDto) {
    User user = userDao.save(userMapper.toUser(signUpRequestDto));
    String token = returnToken(user);
    return new AuthResponseDto(token);
  }

  @Transactional
  @Override
  public AuthResponseDto login(AuthRequestDto request) {
    User user = userDao.findByLoginAndPassword(request.getEmail(), request.getPassword());
    String token = returnToken(user);
    return new AuthResponseDto(token);
  }

  @Override
  public void logout(String token) {
    tokenService.expireToken(token);
  }

  @Override
  public String returnToken(User user) {
    UserInfo userInfo =
        UserInfo.builder()
            .userId(user.getId())
            .userLogin(user.getLogin())
            .userEmail(user.getEmail())
            .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
            .build();
    return "Bearer " + tokenService.generateTokenWithExpirationTime(userInfo);
  }
}
