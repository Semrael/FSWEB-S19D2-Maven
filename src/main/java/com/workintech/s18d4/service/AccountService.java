package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccount();
    Optional<Account> getAccountById(Long id);
    Account createAccount(Account account,Long customerId);
    Account updateAccount(Long id,Account account);
    void deleteAccount(Long id);
}
