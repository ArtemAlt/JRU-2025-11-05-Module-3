package com.example.stategy;

public class CreditCardStrategy implements PaymentStrategy {
    private int cardNumber;

    public CreditCardStrategy(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " to credit card number " + cardNumber);
    }

    @Override
    public String getCode() {
        return "card";
    }
}
