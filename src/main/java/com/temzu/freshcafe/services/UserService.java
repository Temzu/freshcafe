package com.temzu.freshcafe.services;

import com.temzu.freshcafe.dtos.UserDto;

public interface UserService {

  UserDto findUserByLogin(String login);

  UserDto update(UserDto userDto);
}
