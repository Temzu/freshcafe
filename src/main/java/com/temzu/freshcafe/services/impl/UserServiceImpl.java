package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.UserDao;
import com.temzu.freshcafe.dtos.AuthResponseDto;
import com.temzu.freshcafe.dtos.UserDto;
import com.temzu.freshcafe.mappers.UserMapper;
import com.temzu.freshcafe.services.AuthService;
import com.temzu.freshcafe.services.TokenService;
import com.temzu.freshcafe.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  private final UserMapper userMapper;

  private final TokenService tokenService;

  private final AuthService authService;

  @Override
  public UserDto findUserByLogin(String login) {
    return userMapper.toUserDto(userDao.findByLogin(login));
  }

  @Transactional
  @Override
  public UserDto update(UserDto userDto) {
    return userMapper.toUserDto(userDao.update(userMapper.toUser(userDto)));
  }

  @Transactional
  @Override
  public AuthResponseDto updatePass(String newPass, String currentUser, String token) {
    userDao.updatePass(newPass, currentUser);
    tokenService.expireToken(token);
    return new AuthResponseDto(authService.returnToken(userDao.findByLogin(currentUser))) ;
  }
}
