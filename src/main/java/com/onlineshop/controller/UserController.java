package com.onlineshop.controller;

import com.onlineshop.model.User;
import com.onlineshop.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(params = "id")
  public User getUserById(@RequestParam("id") Long id) {
    return userService.getUserById(id);
  }

  @DeleteMapping(params = "id")
  public void deleteUserById(@RequestParam("id") Long id) {
    userService.deleteUserById(id);
  }

  @PutMapping(params = "id")
  public void updateUser(@RequestParam("id") Long id, @RequestParam("email") String email) {
    userService.updateUser(id, email);
  }
}
