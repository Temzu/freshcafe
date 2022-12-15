package com.temzu.freshcafe.enums;

import com.temzu.freshcafe.exceptions.ResourceNotFoundException;
import java.util.Arrays;
import javax.persistence.EntityNotFoundException;

public enum OrderTypes {
  DELIVERY(1, "Доставка"),
  PICKUP(2, "Самовывоз");

  private final int code;
  private final String title;

  OrderTypes(int code, String title) {
    this.code = code;
    this.title = title;
  }

  public int getCode() {
    return code;
  }

  public static OrderTypes of(int code) {
    return Arrays.stream(values())
        .filter(orderType -> orderType.code == code)
        .findFirst()
        .orElseThrow(() -> ResourceNotFoundException.byCode(code, OrderTypes.class));
  }

  public static boolean contains(int code) {
    return Arrays.stream(values()).anyMatch(orderType -> orderType.code == code);
  }

  @Override
  public String toString() {
    return this.title;
  }
}
