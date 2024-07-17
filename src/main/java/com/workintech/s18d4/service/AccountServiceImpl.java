package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AccountRepository;
import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
                return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account,Long customerId) {
        Optional<Customer> customer=customerRepository.findById(customerId);
        if(customer.isPresent()){
            account.setCustomer(customer.get());
            return accountRepository.save(account);
        }
       else{
           return null;
        }
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        Optional<Account> existingAccount=accountRepository.findById(id);
        if(existingAccount.isPresent()){
            Account updateAccount=existingAccount.get();
            updateAccount.setAccountName(account.getAccountName());
            updateAccount.setMoneyAmount(account.getMoneyAmount());
            return accountRepository.save(updateAccount);
        }
        else{
        return null;}
    }

    @Override
    public void deleteAccount(Long id) {
            accountRepository.deleteById(id);
    }
}
