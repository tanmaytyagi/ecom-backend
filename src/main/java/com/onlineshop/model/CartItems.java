package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItems {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  private String id;

  @Column(name = "product_id")
  private String productId;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "product_price")
  private Double productPrice;
}
