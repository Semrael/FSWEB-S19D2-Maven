package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id,Address address) {
        Optional<Address> existingAddress=addressRepository.findById(id);
        if(existingAddress.isPresent()){
           Address updateAddress=existingAddress.get();
           updateAddress.setCity(address.getCity());
           updateAddress.setNo(address.getNo());
           updateAddress.setCountry(address.getCountry());
           updateAddress.setDescription(address.getDescription());
           updateAddress.setStreet(address.getStreet());
           return addressRepository.save(updateAddress);
        }else{
        return null;}
    }

    @Override
    public void deleteAddress(Long id) {
         addressRepository.deleteById(id);
    }
}
