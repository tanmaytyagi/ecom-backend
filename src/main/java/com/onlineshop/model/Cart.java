package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "product_id")
  private String productId;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "product_price")
  private Double productPrice;
}
