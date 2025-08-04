package com.onlineshop.model.dto;

import lombok.Data;

@Data
public class CreateUserDto {
  private String name;
  private String email;
  private String mobile;
  private String password;
}
