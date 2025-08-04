package com.onlineshop.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Data
public class Order {

  @Id private String orderId;
  private String userId;

  private String addressId;
  private String status;
  private LocalDateTime createdAt;
}
