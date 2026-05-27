package com.example.obsertver;

public class Trader implements CurrencyObserver{
    @Override
    public void update(String currency, double amount) {
        System.out.println("Updating " + currency + ", amount: " + amount + " trader");
    }

    @Override
    public String getName() {
        return "Trader";
    }
}
