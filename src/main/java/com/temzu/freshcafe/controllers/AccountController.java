package com.temzu.freshcafe.controllers;

import com.temzu.freshcafe.dtos.AccountInfo;
import com.temzu.freshcafe.dtos.UserDto;
import com.temzu.freshcafe.services.UserService;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@PreAuthorize("isAuthenticated()")
public class AccountController {

  private final UserService userService;

  @GetMapping("/current")
  public UserDto findCurrentAccount(Principal principal) {
    return userService.findUserByLogin(principal.getName());
  }

  @PostMapping("/current")
  public UserDto changeCurrentAccountInfo(Principal principal, UserDto userDto) {
    UserDto curUser = userService.findUserByLogin(principal.getName());
    curUser.setEmail(userDto.getEmail());
    curUser.setLogin(userDto.getLogin());
    return userService.update(curUser);
  }

}
