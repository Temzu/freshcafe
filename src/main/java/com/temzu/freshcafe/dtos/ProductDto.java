package com.temzu.freshcafe.dtos;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductDto {

  private Long id;

  private String title;

  private String imageName;

  private BigDecimal price;

  private String description;

  private String categoryTitle;

}
