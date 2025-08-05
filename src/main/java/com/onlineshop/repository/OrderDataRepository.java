package com.onlineshop.repository;

import com.onlineshop.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDataRepository extends JpaRepository<OrderData, Long> {}
