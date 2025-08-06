package com.onlineshop.service;

import com.onlineshop.model.CartItems;
import com.onlineshop.model.Product;
import com.onlineshop.model.dto.ItemDto;
import com.onlineshop.repository.CartRepository;
import com.onlineshop.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
  private final CartRepository cartRepository;
  private final ProductRepository productRepository;

  @Autowired
  public CartService(CartRepository cartRepository, ProductRepository productRepository) {
    this.cartRepository = cartRepository;
    this.productRepository = productRepository;
  }

  public List<CartItems> getCartByUserId(String userId) {
    return cartRepository.findByUserId(userId);
  }

  public List<CartItems> addItem(ItemDto item) {
    boolean itemExists =
        cartRepository.existsByUserIdAndProductId(item.getUserId(), item.getProductId());

    if (!itemExists) {
      Optional<Product> product = productRepository.findById(item.getProductId());
      if (product.isEmpty()) {
        return null;
      }

      String shortUuid = UUID.randomUUID().toString().substring(0, 8);

      CartItems cartItem =
          CartItems.builder()
              .id(shortUuid)
              .userId(item.getUserId())
              .productId(item.getProductId())
              .productPrice(product.get().getProductPrice())
              .productName(product.get().getProductName())
              .quantity(0)
              .build();
      cartRepository.save(cartItem);
    }

    CartItems fetchedItem =
        cartRepository.findByUserIdAndProductId(item.getUserId(), item.getProductId());
    fetchedItem.setQuantity(fetchedItem.getQuantity() + 1);
    cartRepository.save(fetchedItem);

    return cartRepository.findByUserId(item.getUserId());
  }

  public List<CartItems> removeItem(ItemDto item) {
    CartItems fetchedItem =
        cartRepository.findByUserIdAndProductId(item.getUserId(), item.getProductId());
    fetchedItem.setQuantity(fetchedItem.getQuantity() - 1);
    cartRepository.save(fetchedItem);

    if (fetchedItem.getQuantity() == 0) {
      cartRepository.deleteById(fetchedItem.getId());
    }

    return cartRepository.findByUserId(item.getUserId());
  }
}
