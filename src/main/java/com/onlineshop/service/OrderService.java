package com.onlineshop.service;

import com.onlineshop.repository.OrderDataRepository;
import com.onlineshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final OrderDataRepository orderDataRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository, OrderDataRepository orderDataRepository) {
    this.orderRepository = orderRepository;
    this.orderDataRepository = orderDataRepository;
  }
}
