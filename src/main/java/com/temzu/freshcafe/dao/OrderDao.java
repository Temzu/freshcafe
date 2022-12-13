package com.temzu.freshcafe.dao;

import com.temzu.freshcafe.entities.Order;
import com.temzu.freshcafe.entities.User;
import org.springframework.data.domain.Page;

public interface OrderDao {

  Page<Order> findPageByUser(User user, int page, int pageSize);

  Order saveOrUpdate(Order order);

}
