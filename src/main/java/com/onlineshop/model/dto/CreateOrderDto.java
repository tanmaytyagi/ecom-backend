package com.onlineshop.model.dto;

import lombok.Data;

@Data
public class CreateOrderDto {
  private String userId;
  private String addressId;
}
