package com.onlineshop.service;

import com.onlineshop.model.User;
import com.onlineshop.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.orElse(null);
  }

  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }

  public void updateUser(Long id, String email) {
    Optional<User> userOptional = userRepository.findById(id);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      user.setEmail(email);
      userRepository.save(user);
    } else {
      System.out.println("User not found");
    }
  }
}
