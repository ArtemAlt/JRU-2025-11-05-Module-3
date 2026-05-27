package com.example.obsertver;

public class Bank implements CurrencyObserver {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void update(String currency, double amount) {
        System.out.println("Updating " + currency + ", amount: " + amount + " in Bank " + bankName);
    }

    @Override
    public String getName() {
        return "Bank " + bankName;
    }
}
