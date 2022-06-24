package com.advancejava.groupexercise1.controller;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.helper.model.Deposit;
import com.advancejava.groupexercise1.service.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BankController {

    @Autowired
    private BankServiceImpl bankService;

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account acct){
        bankService.createAccount(acct);
        return acct;
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
    public Page<Account> getAccounts(@PageableDefault(page = 0, size = 10)
                                         @SortDefault.SortDefaults({
                                                 @SortDefault(sort = "name",
                                                         direction = Sort.Direction.ASC)
                                         })
                                                 Pageable pageable){
        return bankService.getAccounts(pageable);
    }

//    @PutMapping("/accounts")
//    public Account updateAccount(Account acct){ return bankService.updateAccount(acct); }

}
