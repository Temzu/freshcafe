package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dtos.OrderReportItem;
import com.temzu.freshcafe.entities.Order;
import com.temzu.freshcafe.entities.OrderItem;
import com.temzu.freshcafe.exceptions.ResourceNotFoundException;
import com.temzu.freshcafe.reports.OrderReportByDate;
import com.temzu.freshcafe.repositories.OrderRepository;
import com.temzu.freshcafe.services.ReportService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

  private final OrderRepository orderRepository;

  @Transactional
  @Override
  public OrderReportByDate generateOrderReportByDate(LocalDate localDate) {
    localDate = localDate.plusDays(1);
    LocalDateTime from = LocalDateTime.of(localDate, LocalTime.MIN);
    LocalDateTime to = LocalDateTime.of(localDate, LocalTime.MAX);

    List<Order> orders = orderRepository.findAllByCreatedAtBetween(from, to);

    if (orders.isEmpty()) {
      throw ResourceNotFoundException.byDate(localDate, OrderReportByDate.class);
    }

    BigDecimal sum = getSum(orders);

    BigDecimal averageCheck = sum.divide(BigDecimal.valueOf(orders.size()), RoundingMode.DOWN);

    List<OrderReportItem> orderReportItems = getOrderReportItems(
        orders);

    return OrderReportByDate.builder()
        .items(orderReportItems)
        .sum(sum)
        .averageCheck(averageCheck)
        .build();
  }

  private BigDecimal getSum(List<Order> orders) {
    return orders.stream()
        .map(Order::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private List<OrderReportItem> getOrderReportItems(List<Order> orders) {
    Map<String, Integer> collect = orders.stream()
        .map(Order::getItems)
        .flatMap(Collection::stream)
        .collect(
            Collectors.groupingBy(
                orderItem -> orderItem.getProduct().getTitle(),
                Collectors.summingInt(OrderItem::getQuantity)));

    return collect.entrySet().stream()
        .map(entry -> new OrderReportItem(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
  }
}
