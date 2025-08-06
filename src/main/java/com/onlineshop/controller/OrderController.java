package com.onlineshop.controller;

import com.onlineshop.model.Order;
import com.onlineshop.model.dto.CreateOrderDto;
import com.onlineshop.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/createOrder")
  public ResponseEntity<List<Order>> createOrder(@RequestBody CreateOrderDto orderData) {
    List<Order> orderHistory = orderService.createOrder(orderData);
    return ResponseEntity.ok(orderHistory);
  }

  @GetMapping("/orderHistory/{userId}")
  public ResponseEntity<List<Order>> getOrderHistory(@PathVariable("userId") String userId) {
    List<Order> orderHistory = orderService.getOrderHistory(userId);
    return ResponseEntity.ok(orderHistory);
  }
}
