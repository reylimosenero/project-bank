package com.advancejava.groupexercise1.controller;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.model.Deposit;
import com.advancejava.groupexercise1.service.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BankController {

    @Autowired
    private BankServiceImpl bankService;

    @PostMapping("/accounts")
    public List<Account> createAccount(@RequestBody Account acct){
        bankService.createAccount(acct);
        return bankService.getAccounts();
    }

    @PostMapping("/accounts/{id}/transactions")
    public Account depositAccount(@RequestBody Deposit deposit, @PathVariable Integer id){
        System.out.println(deposit.getAmount());

        bankService.updateAccount(deposit,id);
        return bankService.getAccount(id);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Integer id){ return bankService.getAccount(id); }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){ return bankService.getAccounts(); }

//    @PutMapping("/accounts")
//    public Account updateAccount(Account acct){ return bankService.updateAccount(acct); }

}
