package com.advancejava.groupexercise1.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.util.Random;

@Entity
@JsonTypeName("checking")
public class CheckingAccount extends Account{

    /**
     * Minimum/starting balance 100.00
     *
     * Penalty of 10.00 if balance falls below minimum
     *
     * Charge of 1.00 per transaction
     */
    public CheckingAccount() {
        Random random = new Random();
        //System.out.println();
        this.setAcctNumber(random.nextInt(1000000));
        this.setBalance(100.00);
        this.setMinimumBalance(100.00);
        this.setPenalty(10.00);
        this.setTransactionCharge(1.00);
        this.setInterestCharge(0.00);
        this.setType("checking");
    }
}
