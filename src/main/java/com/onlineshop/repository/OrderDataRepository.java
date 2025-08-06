package com.onlineshop.repository;

import com.onlineshop.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDataRepository extends JpaRepository<OrderData, String> {

  @Query(
      value =
          """
        SELECT SUM(p.product_price * o.quantity)
        FROM order_data o
        JOIN products p ON o.product_id = p.product_id
        """,
      nativeQuery = true)
  Double calculateTotalRevenue();
}
