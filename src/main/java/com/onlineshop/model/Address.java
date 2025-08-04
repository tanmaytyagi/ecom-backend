package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
public class Address {
  @Id private String addressId;
  private String userId;

  private String fullAddress;
}
