package com.advancejava.groupexercise1.service;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.errorhandler.AccountNotFoundException;
import com.advancejava.groupexercise1.errorhandler.InsuffientBalanceException;
import com.advancejava.groupexercise1.helper.model.Deposit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankService {

    public Account getAccount(Integer id) throws AccountNotFoundException;
    public Page<Account> getAccounts(Pageable pageable);
    public Account createAccount(Account acct);
    public Account updateAccount(Account acct) throws AccountNotFoundException;
    public Account depositAccount(Deposit dep, int id) throws AccountNotFoundException;

    public Account deleteAccount(Integer id) throws AccountNotFoundException;
}
