package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "order_data",
    uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "product_id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderData {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  private String id;

  @Column(name = "order_id")
  private String order;

  @Column(name = "product_id")
  private String product;

  @Column(name = "quantity")
  private Integer quantity;
}
