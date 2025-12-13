package com.onlineshop.controller;

import com.onlineshop.model.Product;
import com.onlineshop.model.dto.CategoryDto;
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

  @PostMapping("/createProductBulk")
  public ResponseEntity<List<Product>> createProductBulk(
      @RequestBody List<CreateProductDto> productsData) {
    List<Product> createdProducts = productService.createProductBulk(productsData);
    return ResponseEntity.ok().body(createdProducts);
  }

  @GetMapping("/getProduct/{productId}")
  public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {
    Product product = productService.getProductById(productId);
    if (product == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(product);
  }

  @GetMapping("/getFeaturedProducts")
  public ResponseEntity<List<Product>> getFeaturedProducts() {
    List<Product> featuredProducts = productService.getFeaturedProducts();
    return ResponseEntity.ok(featuredProducts);
  }

  @GetMapping("/getAllCategories")
  public ResponseEntity<List<CategoryDto>> getCategories() {
    List<CategoryDto> categories = productService.getAllCategories();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/getProductsByCategory/{categoryName}")
  public ResponseEntity<List<Product>> getProductsByCategory(
      @PathVariable("categoryName") String categoryName) {
    List<Product> products = productService.getProductsByCategory(categoryName);
    return ResponseEntity.ok(products);
  }
}
