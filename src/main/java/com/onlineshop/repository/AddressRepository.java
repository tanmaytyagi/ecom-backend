package com.onlineshop.repository;

import com.onlineshop.model.Address;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
  Optional<List<Address>> findByUserId(String userId);
}
