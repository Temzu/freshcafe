package com.temzu.freshcafe.reports;

import com.temzu.freshcafe.dtos.OrderReportItem;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class OrderReportByDate {

  private List<OrderReportItem> items;

  private BigDecimal averageCheck;

  private BigDecimal sum;

}
