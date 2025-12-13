package com.onlineshop.repository;

import com.onlineshop.model.CartItem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, String> {
  boolean existsByProductId(String productId);

  Optional<CartItem> findByProductId(String productId);
}
