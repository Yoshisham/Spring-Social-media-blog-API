package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import com.example.exception.*;

@Service
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account registerAccount(Account account) {
        if (accountRepository.findByUsername(account.getUsername()) != null){
            throw new AccountAlreadyExists();
        }
   
        if (!account.getUsername().isEmpty() && account.getPassword().length()>=4) {
            return accountRepository.save(account);
        }
    
        throw new ClientError();
    }

    public Account userLogin(Account account) {
        Account dbAccount = accountRepository.findByUsername(account.getUsername());

        if (dbAccount != null) {
            if (dbAccount.getUsername().equals(account.getUsername()) && dbAccount.getPassword().equals(account.getPassword())) {
                return dbAccount;
            }
        }
        throw new UnauthorizedLogin();
    }
}
