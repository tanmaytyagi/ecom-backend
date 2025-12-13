package com.onlineshop.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

  @Id
  @Column(name = "order_id", nullable = false, unique = true)
  private String orderId;

  @Column(name = "status")
  private String status;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
