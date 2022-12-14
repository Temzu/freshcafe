package com.temzu.freshcafe.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderCreateDto {

  @NotBlank(message = "Name must not be blank and not be null")
  @Size(min = 3, max = 255, message = "Title length must be between 3-30")
  @Pattern(regexp="^[A-Za-z\\d]*$", message = "Title contains invalid characters")
  private String clientName;

  @NotBlank(message = "Address must not be blank and not be null")
  private String address;

  @NotBlank(message = "Phone must not be blank and not be null")
  @Size(min = 11, max = 11, message = "Phone length must be 11")
  @Pattern(regexp="^\\d*$", message = "Phone contains invalid characters")
  private String phone;
}
