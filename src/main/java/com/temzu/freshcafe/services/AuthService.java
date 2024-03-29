package com.temzu.freshcafe.services;

import com.temzu.freshcafe.dtos.AuthRequestDto;
import com.temzu.freshcafe.dtos.AuthResponseDto;
import com.temzu.freshcafe.dtos.SignUpRequestDto;
import com.temzu.freshcafe.entities.User;

public interface AuthService {

  AuthResponseDto signUp(SignUpRequestDto signUpRequestDto);

  AuthResponseDto login(AuthRequestDto authRequestDto);

  void logout(String token);

  String returnToken(User user);
}
