package com.onlineshop.service;

import com.onlineshop.model.CartItem;
import com.onlineshop.model.Order;
import com.onlineshop.model.OrderData;
import com.onlineshop.model.dto.ResponseBody;
import com.onlineshop.repository.CartRepository;
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
  private final CartRepository cartRepository;

  @Autowired
  public OrderService(
      OrderRepository orderRepository,
      OrderDataRepository orderDataRepository,
      CartRepository cartRepository) {
    this.orderRepository = orderRepository;
    this.orderDataRepository = orderDataRepository;
    this.cartRepository = cartRepository;
  }

  public ResponseBody createOrder() {
    List<CartItem> cartItems = cartRepository.findAll();
    String orderId = "ODER-" + UUID.randomUUID().toString().substring(0, 8);

    for (CartItem cartItem : cartItems) {
      OrderData orderEntry =
          OrderData.builder()
              .id(UUID.randomUUID().toString().substring(0, 8))
              .orderId(orderId)
              .productId(cartItem.getProductId())
              .quantity(cartItem.getQuantity())
              .build();
      orderDataRepository.save(orderEntry);
    }

    ResponseBody response = new ResponseBody();

    if (cartItems.isEmpty()) {
      response.setMessage("Cart is empty");
      response.setStatus("FAILED");
      return response;
    }

    Order order =
        Order.builder().orderId(orderId).status("PENDING").createdAt(LocalDateTime.now()).build();
    orderRepository.save(order);
    cartRepository.deleteAll();

    response.setMessage("Order has been created");
    response.setStatus("SUCCESS");
    return response;
  }

  public List<Order> getOrderHistory() {
    return orderRepository.findAll();
  }
}
