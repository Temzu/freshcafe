package com.temzu.freshcafe.services;

import com.temzu.freshcafe.reports.OrderReportByDate;
import java.time.LocalDate;

public interface ReportService {

  OrderReportByDate generateOrderReportByDate(LocalDate localDate);

}
