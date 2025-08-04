package com.onlineshop.controller;

import com.onlineshop.model.User;
import com.onlineshop.model.dto.CreateUserDto;
import com.onlineshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    if(user == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
  }

  @GetMapping("/getAllUsers")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody CreateUserDto userData) {
    User createdUser = userService.createUser(userData);
    return ResponseEntity.ok(createdUser);
  }
}
