package com.onlineshop.service;

import com.onlineshop.model.CartItems;
import com.onlineshop.model.Product;
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

  public List<CartItems> getCart() {
    return cartRepository.findAll();
  }

  public List<CartItems> addItem(String productId) {
    boolean itemExists = cartRepository.existsByProductId(productId);

    if (!itemExists) {
      Optional<Product> product = productRepository.findById(productId);
      if (product.isEmpty()) {
        return null;
      }

      String shortUuid = UUID.randomUUID().toString().substring(0, 8);

      CartItems cartItem =
          CartItems.builder()
              .id(shortUuid)
              .productId(productId)
              .productPrice(product.get().getProductPrice())
              .productName(product.get().getProductName())
              .quantity(1)
              .build();
      cartRepository.save(cartItem);
      return cartRepository.findAll();
    }

    Optional<CartItems> fetchedItemOpt = cartRepository.findByProductId(productId);
    if (fetchedItemOpt.isPresent()) {
      CartItems fetchedItem = fetchedItemOpt.get();
      fetchedItem.setQuantity(fetchedItem.getQuantity() + 1);
      cartRepository.save(fetchedItem);
    }

    return cartRepository.findAll();
  }

  public List<CartItems> removeItem(String productId) {
    Optional<CartItems> fetchedItemOpt = cartRepository.findByProductId(productId);

    if (fetchedItemOpt.isEmpty()) {
      return cartRepository.findAll();
    }

    CartItems fetchedItem = fetchedItemOpt.get();
    fetchedItem.setQuantity(fetchedItem.getQuantity() - 1);

    if (fetchedItem.getQuantity() == 0) {
      cartRepository.deleteById(fetchedItem.getId());
    } else {
      cartRepository.save(fetchedItem);
    }

    return cartRepository.findAll();
  }

  @Transactional
  public void clearCart() {
    cartRepository.deleteAll();
  }
}
