package com.temzu.freshcafe.services;

import com.temzu.freshcafe.dtos.OrderCreateDto;
import com.temzu.freshcafe.dtos.OrderDto;
import org.springframework.data.domain.Page;

public interface OrderService {

  Page<OrderDto> findPageByUserLogin(String login, int page, int pageSize);

  void createOrder(String login, OrderCreateDto orderCreateDto);

}
