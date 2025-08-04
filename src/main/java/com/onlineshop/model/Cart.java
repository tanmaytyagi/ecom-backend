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
  @Column(name = "cart_id")
  private String cartId;

  @Column(name = "cart_value")
  private Double cartValue;
}
