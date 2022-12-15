package com.temzu.freshcafe.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderCreateDto {

  @NotBlank(message = "Поле с именем не должно быть пустым")
  @Size(min = 3, max = 30, message = "Длина имени должна быть между 3-30 символами")
  private String clientName;

  @NotBlank(message = "Поле с адресом не должно быть пустым")
  private String address;

  @NotBlank(message = "Поле с номером телефона не должно быть пустым")
  @Size(min = 11, max = 11, message = "Phone length must be 11")
  @Pattern(regexp="^\\d*$", message = "Phone contains invalid characters")
  private String phone;

  @NotNull(message = "Order type must be not null")
  @Min(value = 1, message = "Order type must be greater than or equal to 1")
  @Max(value = 2, message = "Order type must be less than or equal to 2")
  private Integer orderTypeValue;

}
