package com.onlineshop.controller;

import com.onlineshop.model.Address;
import com.onlineshop.model.dto.CreateAddressDto;
import com.onlineshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
  private AddressService addressService;

  @Autowired
  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @PostMapping("/createAddress")
  public ResponseEntity<Address> createAddress(@RequestBody CreateAddressDto addressData) {
    Address createdAddress = addressService.createAddress(addressData);
    return ResponseEntity.ok().body(createdAddress);
  }

  @GetMapping("/getAddress/{userId}")
  public ResponseEntity<Address> getAddress(@PathVariable("userId") String userId) {
    Address address = addressService.getAddress(userId);
    return ResponseEntity.ok().body(address);
  }
}
