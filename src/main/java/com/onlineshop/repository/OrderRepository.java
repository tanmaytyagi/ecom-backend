package com.onlineshop.repository;

import com.onlineshop.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
  List<Order> findByUserId(String userId);
}
