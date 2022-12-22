package com.temzu.freshcafe.exceptions;

import com.temzu.freshcafe.enums.ExceptionTypes;

public class ResourceNotFoundException extends ResourceException {

  private static final String NOT_FOUND_BY = "%s not found by %s: %s";

  private ResourceNotFoundException(Class<?> entityClass, ExceptionTypes type, String reason) {
    super(String.format(NOT_FOUND_BY, entityClass.getSimpleName(), type.getType(), reason));
  }

  public static ResourceNotFoundException byId(Long id, Class<?> entityClass) {
    return new ResourceNotFoundException(entityClass, ExceptionTypes.ID, id.toString());
  }

  public static ResourceNotFoundException byCode(Integer code, Class<?> entityClass) {
    return new ResourceNotFoundException(entityClass, ExceptionTypes.CODE, code.toString());
  }

  public static ResourceNotFoundException byName(String name, Class<?> entityClass) {
    return new ResourceNotFoundException(entityClass, ExceptionTypes.NAME, name);
  }

  public static ResourceNotFoundException byTitle(String title, Class<?> entityClass) {
    return new ResourceNotFoundException(entityClass, ExceptionTypes.TITLE, title);
  }

  public static ResourceNotFoundException byLogin(String login, Class<?> entityClass) {
    return new ResourceNotFoundException(entityClass, ExceptionTypes.LOGIN, login);
  }

  public static ResourceNotFoundException byUuid(String uuid, Class<?> entityClass) {
    return new ResourceNotFoundException(entityClass, ExceptionTypes.UUID, uuid);
  }

  public static ResourceNotFoundException byEmail(String uuid, Class<?> entityClass) {
    return new ResourceNotFoundException(entityClass, ExceptionTypes.EMAIL, uuid);
  }
}
