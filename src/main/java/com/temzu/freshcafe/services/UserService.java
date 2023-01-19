package com.temzu.freshcafe.services;

import com.temzu.freshcafe.dtos.AuthResponseDto;
import com.temzu.freshcafe.dtos.UserDto;

public interface UserService {

  UserDto findUserByLogin(String login);

  UserDto update(UserDto userDto);

  AuthResponseDto updatePass(String newPass, String currentUser, String token);
}
