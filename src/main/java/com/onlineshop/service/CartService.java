package com.onlineshop.service;

import com.onlineshop.model.CartItem;
import com.onlineshop.model.Product;
import com.onlineshop.model.dto.CartDto;
import com.onlineshop.model.dto.OrderSummary;
import com.onlineshop.repository.CartRepository;
import com.onlineshop.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {
  private final CartRepository cartRepository;
  private final ProductRepository productRepository;

  @Autowired
  public CartService(CartRepository cartRepository, ProductRepository productRepository) {
    this.cartRepository = cartRepository;
    this.productRepository = productRepository;
  }

  public CartDto getCart() {
    CartDto cartDto = new CartDto();
    List<CartItem> cartItems = cartRepository.findAll();
    cartDto.setCartItems(cartItems);
    Double subtotal = (double) 0;
    Integer totalItems = 0;
    for (CartItem cartItem : cartItems) subtotal += cartItem.getTotalPrice();
    for (CartItem cartItem : cartItems) totalItems += cartItem.getQuantity();
    cartDto.setTotalItems(totalItems);
    OrderSummary orderSummary = new OrderSummary();
    orderSummary.setSubtotal(subtotal);
    orderSummary.setTaxPercentage(18);
    orderSummary.setTaxAmount(0.18 * subtotal);
    orderSummary.setTotal(orderSummary.getTaxAmount() + orderSummary.getSubtotal());
    cartDto.setOrderSummary(orderSummary);
    return cartDto;
  }

  public CartDto addItem(String productId) {
    boolean itemExists = cartRepository.existsByProductId(productId);

    if (!itemExists) {
      Optional<Product> product = productRepository.findById(productId);
      if (product.isEmpty()) {
        return getCart();
      }

      String shortUuid = UUID.randomUUID().toString().substring(0, 8);

      CartItem cartItem =
          CartItem.builder()
              .id(shortUuid)
              .productId(productId)
              .productPrice(product.get().getProductPrice())
              .productName(product.get().getProductName())
              .productCategory(product.get().getProductCategory())
              .quantity(1)
              .totalPrice(product.get().getProductPrice())
              .build();
      cartRepository.save(cartItem);
      return getCart();
    }

    Optional<CartItem> fetchedItemOpt = cartRepository.findByProductId(productId);
    if (fetchedItemOpt.isPresent()) {
      CartItem fetchedItem = fetchedItemOpt.get();
      fetchedItem.setQuantity(fetchedItem.getQuantity() + 1);
      fetchedItem.setTotalPrice(fetchedItem.getTotalPrice() + fetchedItem.getProductPrice());
      cartRepository.save(fetchedItem);
    }

    return getCart();
  }

  public CartDto removeItem(String productId) {
    Optional<CartItem> fetchedItemOpt = cartRepository.findByProductId(productId);

    if (fetchedItemOpt.isEmpty()) {
      return getCart();
    }

    CartItem fetchedItem = fetchedItemOpt.get();
    fetchedItem.setQuantity(fetchedItem.getQuantity() - 1);
    fetchedItem.setTotalPrice(fetchedItem.getTotalPrice() - fetchedItem.getProductPrice());

    if (fetchedItem.getQuantity() == 0) {
      cartRepository.deleteById(fetchedItem.getId());
    } else {
      cartRepository.save(fetchedItem);
    }

    return getCart();
  }

  @Transactional
  public CartDto clearCart() {
    cartRepository.deleteAll();
    return getCart();
  }
}
