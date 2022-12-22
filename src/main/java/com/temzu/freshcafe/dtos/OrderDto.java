package com.temzu.freshcafe.dtos;

import com.temzu.freshcafe.enums.OrderStatuses;
import com.temzu.freshcafe.enums.OrderTypes;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class OrderDto {

  private Long id;

  private String address;

  private String phone;

  private BigDecimal price;

  private String orderStatus;

  private String orderType;

  private List<OrderItemDto> items;
}
