package com.onlineshop.service;

import com.onlineshop.model.Product;
import com.onlineshop.model.dto.CreateProductDto;
import com.onlineshop.repository.ProductRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product createProduct(CreateProductDto productData) {
    String shortUuid = UUID.randomUUID().toString().substring(0, 8);

    Product product =
        Product.builder()
            .productId("PROD-" + shortUuid)
            .productName(productData.getProductName())
            .productDescription(productData.getProductDescription())
            .productPrice(productData.getProductPrice())
            .productCategory(productData.getProductCategory())
            .productImageUrl(productData.getProductImageUrl())
            .build();

    return productRepository.save(product);
  }
}
