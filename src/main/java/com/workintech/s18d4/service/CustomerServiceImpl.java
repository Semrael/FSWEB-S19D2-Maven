package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer=customerRepository.findById(id);
        if(existingCustomer.isPresent()){
            Customer updateCustomer=existingCustomer.get();
           updateCustomer.setAddress(customer.getAddress());
            updateCustomer.setFirstName(customer.getFirstName());
            updateCustomer.setLastName(customer.getLastName());
            updateCustomer.setEmail(customer.getEmail());
            updateCustomer.setSalary(customer.getSalary());
            return customerRepository.save(updateCustomer);
        }
        else{return null;}
    }

    @Override
    public void deleteCustomer(Long id) {
         customerRepository.deleteById(id);
    }
}
