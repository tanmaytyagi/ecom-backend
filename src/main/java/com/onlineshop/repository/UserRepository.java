package com.onlineshop.repository;

import com.onlineshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

  // getAllUsers → already available as findAll()

  // getUserById → available in CrudRepository interface

  // save(User)  → Set/add/update a user available in CrudRepository interface
}
