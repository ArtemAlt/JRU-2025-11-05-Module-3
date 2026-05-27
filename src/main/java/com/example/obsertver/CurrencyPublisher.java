package com.example.obsertver;

interface CurrencyPublisher {
    void subscribe(CurrencyObserver observer);
    void unsubscribe(CurrencyObserver observer);
    void notify(String currency, double amount);
}
