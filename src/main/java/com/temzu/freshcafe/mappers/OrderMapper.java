package com.temzu.freshcafe.mappers;

import com.temzu.freshcafe.dtos.OrderDto;
import com.temzu.freshcafe.entities.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

  private final ModelMapper mapper;

  public OrderDto toOrderDto(Order order) {
    return mapper.map(order, OrderDto.class);
  }
}
