package com.advancejava.groupexercise1.helper;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.errorhandler.InsuffientBalanceException;
import org.springframework.stereotype.Component;

@Component
public class CheckBalance {

    public void isWithdrawAmountExceedsBalance(Double withdrawAmount, Double balance)
            throws InsuffientBalanceException{
        if(withdrawAmount > balance) {
            throw new InsuffientBalanceException();
        }
    }

    public double isBelowMinimumBalance(Account acct){
        if(acct.getBalance() < acct.getMinimumBalance()){
            return acct.getBalance() - acct.getPenalty();
        }else{
            return acct.getBalance();
        }

    }


}
