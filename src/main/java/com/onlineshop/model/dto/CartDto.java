package com.onlineshop.model.dto;

import com.onlineshop.model.CartItem;
import java.util.List;
import lombok.Data;

@Data
public class CartDto {
  private List<CartItem> cartItems;
  private OrderSummary orderSummary;
  private Integer totalItems;
}
