package com.onlineshop.repository;

import com.onlineshop.model.Address;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
  Optional<Address> findByUserId(String userId);
}
