package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
public class Product {

  @Id private String productId;

  private String productName;
  private String productDescription;
  private Double productPrice;
  private String productImageUrl;
}
