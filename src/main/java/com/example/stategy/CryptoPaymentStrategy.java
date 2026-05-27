package com.example.stategy;

public class CryptoPaymentStrategy implements PaymentStrategy {
    private String cryptoWallet;

    public CryptoPaymentStrategy(String cryptoWallet) {
        this.cryptoWallet = cryptoWallet;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " to crypto wallet number " + cryptoWallet);
    }

    @Override
    public String getCode() {
        return "crypto";
    }
}
