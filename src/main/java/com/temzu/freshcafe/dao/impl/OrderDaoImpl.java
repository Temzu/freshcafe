package com.temzu.freshcafe.dao.impl;

import com.temzu.freshcafe.dao.OrderDao;
import com.temzu.freshcafe.entities.Order;
import com.temzu.freshcafe.entities.User;
import com.temzu.freshcafe.enums.OrderStatuses;
import com.temzu.freshcafe.exceptions.ResourceNotFoundException;
import com.temzu.freshcafe.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
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
  public Order findById(Long id) {
    return orderRepository
        .findById(id)
        .orElseThrow(() -> ResourceNotFoundException.byId(id, Order.class));
  }

  @Override
  public Order saveOrUpdate(Order order) {
    return orderRepository.save(order);
  }

  @Override
  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  @Override
  public void changeStatus(Long id) {
    Order order = findById(id);
    int newStatus = order.getOrderStatusValue() + 1;
    if (newStatus > 4) {
      newStatus = 4;
    }
    order.setOrderStatusValue(newStatus);
    orderRepository.save(order);
  }
}
