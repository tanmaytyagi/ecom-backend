package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "order_id")
  private String order;

  @Column(name = "product_id")
  private String product;

  @Column(name = "quantity")
  private Integer quantity;
}
