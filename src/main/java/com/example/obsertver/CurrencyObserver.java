package com.example.obsertver;

interface CurrencyObserver {
    void update(String currency, double amount);
    String getName();
}
