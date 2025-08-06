package com.onlineshop.repository;

import com.onlineshop.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDataRepository extends JpaRepository<OrderData, String> {}
