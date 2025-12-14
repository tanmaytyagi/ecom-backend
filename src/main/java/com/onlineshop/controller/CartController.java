package com.onlineshop.controller;

import com.onlineshop.model.dto.CartDto;
import com.onlineshop.model.dto.ResponseBody;
import com.onlineshop.service.CartService;
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
  public ResponseEntity<CartDto> getCart() {
    CartDto cart = cartService.getCart();
    return ResponseEntity.ok(cart);
  }

  @PostMapping("/addItem/{productId}")
  public ResponseEntity<CartDto> addItem(@PathVariable("productId") String productId) {
    CartDto cart = cartService.addItem(productId);
    return ResponseEntity.ok(cart);
  }

  @PostMapping("/removeItem/{productId}")
  public ResponseEntity<CartDto> removeItem(@PathVariable("productId") String productId) {
    CartDto cart = cartService.removeItem(productId);
    return ResponseEntity.ok(cart);
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
