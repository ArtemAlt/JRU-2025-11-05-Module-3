package com.example.stategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payed by cash amount " + amount);
    }
    @Override
    public String getCode() {
        return "cash";
    }
}
