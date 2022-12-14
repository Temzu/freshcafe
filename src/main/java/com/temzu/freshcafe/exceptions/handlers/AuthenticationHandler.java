package com.temzu.freshcafe.exceptions.handlers;

import com.temzu.freshcafe.exceptions.MarketError;
import com.temzu.freshcafe.exceptions.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthenticationHandler {

  @ExceptionHandler(TokenExpiredException.class)
  public ResponseEntity<?> catchTokenExpiredException(TokenExpiredException ex) {
    return new ResponseEntity<>(new MarketError(ex.getMessage()), HttpStatus.UNAUTHORIZED);
  }
}
