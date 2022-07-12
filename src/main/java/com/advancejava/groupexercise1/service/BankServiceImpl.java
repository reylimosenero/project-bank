package com.advancejava.groupexercise1.service;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.errorhandler.AccountNotFoundException;
import com.advancejava.groupexercise1.feign.ProducerFeign;
import com.advancejava.groupexercise1.helper.CheckAccountType;
import com.advancejava.groupexercise1.helper.CheckBalance;
import com.advancejava.groupexercise1.helper.model.Deposit;
import com.advancejava.groupexercise1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CheckBalance checkBalance;

	@Autowired
	CheckAccountType checkAccountType;

	@Autowired
	ProducerFeign producerFeign;

	public Account getAccount(Integer id) throws AccountNotFoundException {

		if (accountRepository.findById(id).isPresent()) {
			return accountRepository.findById(id).get();
		} else {
			throw new AccountNotFoundException();
		}
	}

	public Account getAccountByAccountNumber(int accNo) {
		 Account accountNUmber = null;
		 try {

		 accountNUmber = accountRepository.findByAcctNumber(accNo);
		 } catch (NullPointerException e) {
		 System.out.println(e.getMessage());
		 }

		 if(accountNUmber != null){
		 return accountRepository.findByAcctNumber(accNo);
		 }else {
			 throw new ResponseStatusException(
			 HttpStatus.NOT_FOUND, "entity not found"
			 );
		 }

	}

	public Page<Account> getAccounts(Pageable pageable) {

		return accountRepository.findAll(pageable);
	}

	@Override
	public Account createAccount(Account acct) {
		Account savedAccount =  accountRepository.save(acct);
		producerFeign.createAccount(savedAccount);
		return savedAccount;
	}

	@Override
	public Account depositAccount(Deposit dep, int id) throws AccountNotFoundException {
		Account acct;
		// get Account data by Id
		acct = getAccount(id);
		double amount = dep.getAmount();
		// TODO: do not accept negative and invalid numbers && invalid account
		// type

		String type = dep.getType();
		switch (type) {
		case "deposit":
			acct.setBalance(acct.getBalance() + amount);
			acct.setId(id);
			break;
		case "withdraw":
			acct.setBalance(acct.getBalance() - amount);
			acct.setId(id);
			break;
		default:
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}
		// check regular, checking
		// TODO: check interest
		checkAccountType.checkAccountType(acct);

		// check deductible if below minimum for regular
		acct.setBalance(checkBalance.isBelowMinimumBalance(acct));
		Account savedAccount =  accountRepository.save(acct);
		producerFeign.deposit(dep, id);
		return savedAccount;

	}

	public Account deleteAccount(Integer id) throws AccountNotFoundException{
		Account account = getAccount(id);
		accountRepository.delete(account);

		return account;
	}

	@Override
	public Account updateAccount(Account acct) throws AccountNotFoundException {
		Account retrievedAccount = getAccount(acct.getId());
		retrievedAccount.setName(acct.getName());

		return accountRepository.save(retrievedAccount);
	}
}
