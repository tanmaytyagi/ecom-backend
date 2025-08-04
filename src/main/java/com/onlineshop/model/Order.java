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
  @Column(name = "order_id")
  private String orderId;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "address_id")
  private String addressId;

  @Column(name = "status")
  private String status;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
