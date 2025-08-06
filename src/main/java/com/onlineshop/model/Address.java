package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

  @Id
  @Column(name = "address_id", nullable = false, unique = true)
  private String addressId;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "full_address")
  private String fullAddress;
}
