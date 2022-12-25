package com.temzu.freshcafe.controllers;

import com.temzu.freshcafe.reports.OrderReportByDate;
import com.temzu.freshcafe.repositories.OrderRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
public class ReportController {

  private final OrderRepository orderRepository;

  @PostMapping("/order_report_date")
  public OrderReportByDate generateOrderReportByDate(@RequestBody LocalDate date) {
    System.out.println(date);
    LocalDateTime from = LocalDateTime.of(date, LocalTime.MIN);
    LocalDateTime to = LocalDateTime.of(date, LocalTime.MAX);
    System.out.println(orderRepository.findAllByCreatedAtBetween(from, to));
    return null;
  }

}
