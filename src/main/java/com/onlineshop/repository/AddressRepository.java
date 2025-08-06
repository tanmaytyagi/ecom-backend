package com.onlineshop.repository;

import com.onlineshop.model.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
  List<Address> findByUserId(String userId);
}
