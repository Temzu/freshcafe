package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.OrderDao;
import com.temzu.freshcafe.dao.UserDao;
import com.temzu.freshcafe.dtos.OrderCreateDto;
import com.temzu.freshcafe.dtos.OrderDto;
import com.temzu.freshcafe.entities.Order;
import com.temzu.freshcafe.entities.OrderItem;
import com.temzu.freshcafe.entities.User;
import com.temzu.freshcafe.enums.OrderStatuses;
import com.temzu.freshcafe.mappers.OrderItemMapper;
import com.temzu.freshcafe.mappers.OrderMapper;
import com.temzu.freshcafe.services.CartService;
import com.temzu.freshcafe.services.OrderService;
import com.temzu.freshcafe.services.RedisService;
import com.temzu.freshcafe.util.Cart;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderDao orderDao;

  private final UserDao userDao;

  private final CartService cartService;

  private final RedisService<Cart> redisService;

  private final OrderItemMapper orderItemMapper;

  private final OrderMapper orderMapper;

  @Transactional(readOnly = true)
  @Override
  public Page<OrderDto> findPageByUserLogin(String login, int page, int pageSize) {
    User curUser = userDao.findByLogin(login);
    return orderDao
        .findPageByUser(curUser, page, pageSize)
        .map(orderMapper::toOrderDto);
  }

  @Transactional
  @Override
  public void createOrder(String login, OrderCreateDto orderCreateDto) {
    Cart cart = cartService.getCurrentCart(cartService.getCartUuidFromSuffix(login));
    Order order =
        Order.builder()
            .phone(orderCreateDto.getPhone())
            .address(orderCreateDto.getAddress())
            .clientName(orderCreateDto.getClientName())
            .orderTypeValue(orderCreateDto.getOrderTypeValue())
            .orderStatusValue(OrderStatuses.ORDER_PROCESSING.getCode())
            .user(userDao.findByLogin(login))
            .price(cart.getPrice())
            .build();

    order.setItems(
        cart.getItems().stream()
            .map(
                oid -> {
                  OrderItem orderItem = orderItemMapper.toOrderItem(oid);
                  orderItem.setOrder(order);
                  return orderItem;
                })
            .collect(Collectors.toList()));
    cart.clear();
    orderDao.saveOrUpdate(order);
    redisService.set(cartService.getCartUuidFromSuffix(login), cart);
  }
}
