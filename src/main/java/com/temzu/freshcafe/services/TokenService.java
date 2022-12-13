package com.temzu.freshcafe.services;

import com.temzu.freshcafe.entities.UserInfo;

public interface TokenService {

  String generateTokenWithExpirationTime(UserInfo user);

  void expireToken(String token);

  UserInfo parseToken(String token);

  Long getUserId(String token);
}
