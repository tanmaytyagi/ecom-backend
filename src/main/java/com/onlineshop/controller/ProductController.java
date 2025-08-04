package com.onlineshop.controller;

import com.onlineshop.model.Product;
import com.onlineshop.model.dto.CreateProductDto;
import com.onlineshop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/getAllProducts")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.getAllProducts();
    return ResponseEntity.ok(products);
  }

  @PostMapping("/createProduct")
  public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto productData) {
    Product createdProduct = productService.createProduct(productData);
    return ResponseEntity.ok().body(createdProduct);
  }
}
