package com.onlineshop.repository;

import com.onlineshop.model.CartItems;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItems, String> {
  boolean existsByProductId(String productId);

  Optional<CartItems> findByProductId(String productId);
}
