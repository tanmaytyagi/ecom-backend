package com.onlineshop.repository;

import com.onlineshop.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
  List<Product> findByIsFeaturedTrue();
}
