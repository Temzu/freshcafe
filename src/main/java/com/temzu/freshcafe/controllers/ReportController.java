package com.temzu.freshcafe.controllers;

import com.temzu.freshcafe.reports.OrderReportByDate;
import com.temzu.freshcafe.services.ReportService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
public class ReportController {

  private final ReportService reportService;

  @PostMapping("/order_report_date")
  public OrderReportByDate generateOrderReportByDate(@RequestBody LocalDate date) {
    return reportService.generateOrderReportByDate(date);
  }

}
