package com.onlineshop.controller;

import com.onlineshop.model.CartItems;
import com.onlineshop.model.dto.ItemDto;
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

  @GetMapping("/{userId}")
  public ResponseEntity<List<CartItems>> getCart(@PathVariable("userId") String userId) {
    List<CartItems> items = cartService.getCartByUserId(userId);
    return ResponseEntity.ok(items);
  }

  @PostMapping("/addItem")
  public ResponseEntity<List<CartItems>> addItem(@RequestBody ItemDto item) {
    List<CartItems> items = cartService.addItem(item);
    return ResponseEntity.ok(items);
  }

  @PostMapping("/removeItem")
  public ResponseEntity<List<CartItems>> removeItem(@RequestBody ItemDto item) {
    List<CartItems> items = cartService.removeItem(item);
    return ResponseEntity.ok(items);
  }
}
