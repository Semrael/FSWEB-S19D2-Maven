package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workintech/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    private CustomerService customerService;
    @GetMapping
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Optional<Account> account=accountService.getAccountById(id);
        if(account.isPresent()){
            return ResponseEntity.ok(account.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{customerId}")
    public ResponseEntity<Account> createAccount(@PathVariable Long customerId,@RequestBody Account account ){
       Optional<Customer> customer =customerService.getCustomerById(customerId);
       if(customer.isPresent()){
           account.setCustomer(customer.get());
           Account createAccount=accountService.createAccount(account,customerId);
           return ResponseEntity.ok(createAccount);
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long customerId,@RequestBody Account account){
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        if(customer.isPresent()){
            account.setCustomer(customer.get());
           Account updateAccount= accountService.updateAccount(account.getId(),account);
            if(updateAccount !=null){
                return ResponseEntity.ok(updateAccount);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
