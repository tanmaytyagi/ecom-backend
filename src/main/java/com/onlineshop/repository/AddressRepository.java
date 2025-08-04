package com.onlineshop.repository;

import com.onlineshop.model.Address;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
  Optional<List<Address>> findByUserId(String userId);
}
