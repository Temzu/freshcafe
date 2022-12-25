package com.temzu.freshcafe.repositories;

import com.temzu.freshcafe.entities.Order;
import com.temzu.freshcafe.entities.User;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  Page<Order> findAllByUser(User user, Pageable pageable);

  List<Order> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to);
}
