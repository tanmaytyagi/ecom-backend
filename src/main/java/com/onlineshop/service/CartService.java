package com.onlineshop.service;

import com.onlineshop.model.Cart;
import com.onlineshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
  private final CartRepository cartRepository;

  @Autowired
  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public void createCart(String userId) {
    Cart cart = new Cart(userId, 0.00);
    cartRepository.save(cart);
  }
}
