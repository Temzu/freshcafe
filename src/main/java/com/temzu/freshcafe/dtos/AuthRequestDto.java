package com.temzu.freshcafe.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthRequestDto {

  @NotBlank(message = "Email must not be blank and not be null")
  @Email
  private String email;

  @NotBlank(message = "Password must not be blank and not be null")
  @Size(min = 6, max = 80, message = "Password length must be between 6-80")
  private String password;
}
