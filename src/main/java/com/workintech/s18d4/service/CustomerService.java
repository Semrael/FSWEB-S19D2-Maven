package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Optional<Customer> getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id,Customer customer);
    void deleteCustomer(Long id);

}
