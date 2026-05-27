package com.example.stategy;

public enum StrategySwitcher {
    CADR(new CreditCardStrategy(65464)),
    CRYPTO(new CryptoPaymentStrategy("dfgdffg")),
    CASH(new CashPaymentStrategy());

    private final PaymentStrategy strategy;

    StrategySwitcher(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}
