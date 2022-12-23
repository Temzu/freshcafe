package com.temzu.freshcafe.dao;

import com.temzu.freshcafe.entities.Order;
import com.temzu.freshcafe.entities.User;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Page;

public interface OrderDao {

  Page<Order> findPageByUser(User user, int page, int pageSize);

  Order findById(Long id);

  Order saveOrUpdate(Order order);

  List<Order> findAll();

  void changeStatus(Long id);
}
