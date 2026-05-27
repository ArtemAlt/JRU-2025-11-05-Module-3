package com.example.obsertver;

import java.util.ArrayList;
import java.util.List;

public class CurrencyExigence implements CurrencyPublisher {
    private List<CurrencyObserver> observers = new ArrayList<>();

    @Override
    public void subscribe(CurrencyObserver observer) {
        observers.add(observer);
        System.out.println(observer.getName() + " subscribed");
    }

    @Override
    public void unsubscribe(CurrencyObserver observer) {
        observers.remove(observer);
        System.out.println(observer.getName() + " unsubscribed");
    }

    @Override
    public void notify(String currency, double amount) {
        for (CurrencyObserver observer : observers) {
            observer.update(currency, amount);
        }
    }

    public void setNewRange(String currency, double amount) {
        System.out.println("Setting new range for currency: " + currency + ", amount: " + amount);
        notify(currency, amount);
    }
}
