package com.temzu.freshcafe.exceptions.handlers;

import com.temzu.freshcafe.exceptions.MarketError;
import com.temzu.freshcafe.exceptions.ResourceAlreadyExistsException;
import com.temzu.freshcafe.exceptions.ResourceException;
import com.temzu.freshcafe.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> catchResourceNotFoundException(ResourceException e) {
    return new ResponseEntity<>(new MarketError(e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public ResponseEntity<?> catchResourceAlreadyExistException(ResourceException e) {
    return new ResponseEntity<>(new MarketError(e.getMessage()), HttpStatus.CONFLICT);
  }
}
