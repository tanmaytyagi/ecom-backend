package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
public class CartData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String cartId;

  private String productId;
  private String productName;
  private Integer quantity;
  private Double productPrice;
}
