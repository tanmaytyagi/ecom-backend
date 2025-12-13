package com.onlineshop.controller;

import com.onlineshop.model.CartItem;
import com.onlineshop.model.dto.ResponseBody;
import com.onlineshop.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
  private final CartService cartService;

  @Autowired
  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("/getCart")
  public ResponseEntity<List<CartItem>> getCart() {
    List<CartItem> items = cartService.getCart();
    return ResponseEntity.ok(items);
  }

  @PostMapping("/addItem/{productId}")
  public ResponseEntity<List<CartItem>> addItem(@PathVariable("productId") String productId) {
    List<CartItem> items = cartService.addItem(productId);
    return ResponseEntity.ok(items);
  }

  @PostMapping("/removeItem/{productId}")
  public ResponseEntity<List<CartItem>> removeItem(@PathVariable("productId") String productId) {
    List<CartItem> items = cartService.removeItem(productId);
    return ResponseEntity.ok(items);
  }

  @DeleteMapping("/clearCart")
  public ResponseEntity<ResponseBody> clearCart() {
    cartService.clearCart();
    ResponseBody response = new ResponseBody();
    response.setMessage("Cart cleared successfully");
    response.setStatus("SUCCESS");
    return ResponseEntity.ok(response);
  }
}
