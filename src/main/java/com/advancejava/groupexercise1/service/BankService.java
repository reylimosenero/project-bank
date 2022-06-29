package com.advancejava.groupexercise1.service;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.helper.model.Deposit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankService {

    public Account getAccount(int acctNumber);
    public Page<Account> getAccounts(Pageable pageable);
    public Account createAccount(Account acct);
    public Account updateAccount(Account acct);
    public Account depositAccount(Deposit dep, int id);

    public Account deleteAccount(Integer id);
}
