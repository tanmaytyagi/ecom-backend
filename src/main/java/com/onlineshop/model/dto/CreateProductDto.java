package com.onlineshop.model.dto;

import lombok.Data;

@Data
public class CreateProductDto {
  private String productName;
  private String productDescription;
  private Double productPrice;
  private String productCategory;
  private String productImageUrl;
}
