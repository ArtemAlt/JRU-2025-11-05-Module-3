package com.example.stategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void payCart(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment strategy not selected");
        } else {
            paymentStrategy.pay(amount);
        }
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
