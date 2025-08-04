package com.onlineshop.controller;

import com.onlineshop.model.User;
import com.onlineshop.model.dto.CreateUserDto;
import com.onlineshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{userId}")
  public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
    User user = userService.getUserById(userId);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody CreateUserDto userData) {
    User createdUser = userService.createUser(userData);
    return ResponseEntity.ok(createdUser);
  }
}
