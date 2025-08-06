package com.onlineshop.repository;

import com.onlineshop.model.CartItems;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItems, String> {
  List<CartItems> findByUserId(String userId);

  boolean existsByUserIdAndProductId(String userId, String productId);

  CartItems findByUserIdAndProductId(String userId, String productId);

  void deleteByUserId(String userId);
}
