package com.onlineshop.controller;

import com.onlineshop.model.Order;
import com.onlineshop.model.dto.ResponseBody;
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
  public ResponseEntity<ResponseBody> createOrder() {
    return ResponseEntity.ok().body(orderService.createOrder());
  }

  @GetMapping("/orderHistory")
  public ResponseEntity<List<Order>> getOrderHistory() {
    List<Order> orderHistory = orderService.getOrderHistory();
    return ResponseEntity.ok(orderHistory);
  }
}
