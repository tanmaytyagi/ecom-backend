package com.onlineshop.model.dto;

import lombok.Data;

@Data
public class OrderSummary {
  private Double subtotal;
  private Integer taxPercentage;
  private Double taxAmount;
  private Double total;
}
