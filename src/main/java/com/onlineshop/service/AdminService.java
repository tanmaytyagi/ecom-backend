package com.onlineshop.service;

import com.onlineshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
  private final OrderDataRepository orderDataRepository;
  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;
  private final AddressRepository addressRepository;
  private final UserRepository userRepository;

  @Autowired
  public AdminService(
      OrderDataRepository orderDataRepository,
      OrderRepository orderRepository,
      ProductRepository productRepository,
      UserRepository userRepository,
      AddressRepository addressRepository) {
    this.orderDataRepository = orderDataRepository;
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
    this.userRepository = userRepository;
    this.addressRepository = addressRepository;
  }

  // revenue -> total revenue generated ->
}
