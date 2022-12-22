package com.temzu.freshcafe.dao.impl;

import com.temzu.freshcafe.dao.OrderDao;
import com.temzu.freshcafe.entities.Order;
import com.temzu.freshcafe.entities.User;
import com.temzu.freshcafe.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {

  private final OrderRepository orderRepository;

  @Override
  public Page<Order> findPageByUser(User user, int page, int pageSize) {
    return orderRepository.findAllByUser(user, PageRequest.of(page - 1, pageSize));
  }

  @Override
  public Order saveOrUpdate(Order order) {
    return orderRepository.save(order);
  }
}

