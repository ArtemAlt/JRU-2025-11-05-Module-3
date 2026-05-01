package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class BankAccount {

    private final Logger log = LoggerFactory.getLogger(BankAccount.class);

    private final Long accountNumber;
    private final String userName;
    private Double balance;

    public BankAccount(String userName) {
        this.accountNumber = new Random().nextLong();
        this.userName = userName;
        this.balance = 0.0;
        log.info("Created BankAccount for userName={}", userName);
        log.debug("Created BankAccount for userName={} with number {} balance {}", userName, accountNumber, balance);
    }

    public void deposit(Double amount) {
        log.debug("deposit amount={}", amount);
        if (amount == null || amount <= 0) {
            log.warn("amount is negative");
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        balance += amount;
        log.info("New deposit amount={}", amount);
    }

    public void withdraw(Double amount) {
        log.debug("withdraw amount={}", amount);
        if (amount == null || amount <= 0) {
            log.warn("amount is negative");
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (amount > balance) {
            log.warn("amount greater than balance");
            throw new IllegalArgumentException("Amount is greater than accountBalance");
        }
        balance -= amount;
        log.info("New withdraw amount={} current balance {}", amount, balance);
    }

    public Double getBalance() {
        log.debug("Loading balance for userName={}", userName);
        return balance;
    }
}
