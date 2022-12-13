package com.temzu.freshcafe.mappers;

import com.temzu.freshcafe.dtos.OrderItemDto;
import com.temzu.freshcafe.entities.OrderItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemMapper {

  private final ModelMapper mapper;

  public OrderItem toOrderItem(OrderItemDto orderItemDto) {
    OrderItem orderItem = mapper.map(orderItemDto, OrderItem.class);
    orderItem.setId(null);
    return orderItem;
  }
}
