package com.advancejava.groupexercise1.service;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.helper.model.Deposit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankService {

    public Account getAccount(Integer id);
    public Page<Account> getAccounts(Pageable pageable);
    public Account createAccount(Account acct);
   // public Account updateAccount(Account acct);
    public Account updateAccount(Deposit dep, int id);
}
