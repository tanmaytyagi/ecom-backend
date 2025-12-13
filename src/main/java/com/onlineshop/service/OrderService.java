package com.onlineshop.service;

import com.onlineshop.model.CartItems;
import com.onlineshop.model.Order;
import com.onlineshop.model.OrderData;
import com.onlineshop.repository.OrderDataRepository;
import com.onlineshop.repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final OrderDataRepository orderDataRepository;
  private final CartService cartService;

  @Autowired
  public OrderService(
      OrderRepository orderRepository,
      OrderDataRepository orderDataRepository,
      CartService cartService) {
    this.orderRepository = orderRepository;
    this.orderDataRepository = orderDataRepository;
    this.cartService = cartService;
  }

  public Order createOrder() {
    List<CartItems> cartItems = cartService.getCart();
    String orderId = "ODER-" + UUID.randomUUID().toString().substring(0, 8);

    Order order =
        Order.builder().orderId(orderId).status("PENDING").createdAt(LocalDateTime.now()).build();
    orderRepository.save(order);

    for (CartItems cartItem : cartItems) {
      OrderData orderEntry =
          OrderData.builder()
              .id(UUID.randomUUID().toString().substring(0, 8))
              .orderId(orderId)
              .productId(cartItem.getProductId())
              .quantity(cartItem.getQuantity())
              .build();
      orderDataRepository.save(orderEntry);
    }

    cartService.clearCart();
    return order;
  }

  public List<Order> getOrderHistory() {
    return orderRepository.findAll();
  }
}
