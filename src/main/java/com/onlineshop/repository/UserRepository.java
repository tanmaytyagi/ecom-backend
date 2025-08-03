package com.onlineshop.repository;

import com.onlineshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);

  User findById(long id);

  void deleteById(long id);
}
