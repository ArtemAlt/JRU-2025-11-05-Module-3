package com.example;

public class PayPalSystem {

    public void sendPayment(String email, double amount, String currency){
        System.out.println("Sending payment to " + email + " with amount " + amount + " for currency " + currency);
    }
}
