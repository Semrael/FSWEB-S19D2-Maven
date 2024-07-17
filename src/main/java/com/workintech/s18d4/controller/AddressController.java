package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workintech/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        Optional<Address> address =addressService.getAddressById(id);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id,@RequestBody Address address){
        Address updateAddress= addressService.updateAddress(id,address);
        if(updateAddress!=null){
            return ResponseEntity.ok(updateAddress);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
