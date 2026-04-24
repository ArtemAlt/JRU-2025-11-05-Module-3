package com.example;

import java.util.Random;

public class BankAccount {
    private Integer amount;
    private Integer id;

    public BankAccount() {
        this.amount = 0;
        this.id = new Random().nextInt();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }
}
