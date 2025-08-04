package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
public class Cart {

  @Id private String cartId;
  private Double cartValue;
}
