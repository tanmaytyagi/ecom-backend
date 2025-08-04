package com.onlineshop.service;

import com.onlineshop.model.User;
import com.onlineshop.model.dto.CreateUserDto;
import com.onlineshop.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserById(String userId) {
    return userRepository.findById(userId).orElse(null);
  }

  public User createUser(CreateUserDto userData) {
    String shortUuid = UUID.randomUUID().toString().substring(0, 8);
    User user =
        User.builder()
            .userId("USER-" + shortUuid)
            .name(userData.getName())
            .email(userData.getEmail())
            .mobile(userData.getMobile())
            .password(userData.getPassword())
            .build();
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
