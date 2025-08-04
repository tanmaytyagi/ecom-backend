package com.onlineshop.service;

import com.onlineshop.model.Address;
import com.onlineshop.model.dto.CreateAddressDto;
import com.onlineshop.repository.AddressRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
  private final AddressRepository addressRepository;

  @Autowired
  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public Address createAddress(CreateAddressDto addressData) {
    String shortUuid = UUID.randomUUID().toString().substring(0, 8);

    Address address =
        Address.builder()
            .addressId("ADDR-" + shortUuid)
            .userId(addressData.getUserId())
            .fullAddress(addressData.getFullAddress())
            .build();

    return addressRepository.save(address);
  }

  public Address getAddress(String userId) {
    Optional<Address> address = addressRepository.findByUserId(userId);
    return address.orElse(null);
  }
}
