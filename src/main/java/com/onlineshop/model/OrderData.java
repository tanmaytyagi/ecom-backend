package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
public class OrderData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String orderId;
  private String productId;
  private Integer quantity;
}
