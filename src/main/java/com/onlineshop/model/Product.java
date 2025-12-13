package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

  @Id
  @Column(name = "product_id", nullable = false, unique = true)
  private String productId;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "product_description")
  private String productDescription;

  @Column(name = "product_price")
  private Double productPrice;

  @Column(name = "product_category")
  private String productCategory;

  @Column(name = "product_image_url")
  private String productImageUrl;

  @Column(name = "is_featured")
  private Boolean isFeatured;
}
