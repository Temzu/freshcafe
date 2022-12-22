package com.temzu.freshcafe.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryCreateDto {

  @NotBlank(message = "Title must not be blank and not be null")
  @Size(min = 3, max = 20, message = "Title length must be between 3-20")
  @Pattern(regexp="^[А-Яа-я\\s]$", message = "Title contains invalid characters")
  private String title;

}
