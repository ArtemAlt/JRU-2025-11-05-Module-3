package com.example;

public class PaymentServiceAdapter implements PaymentService {
    private final PayPalSystem payPalSystem;
    // userService

    public PaymentServiceAdapter(PayPalSystem payPalSystem) {
        this.payPalSystem = payPalSystem;
    }

    @Override
    public void pay(String cardNumber, double amount) {
        String currency = "USD";
        String email = ""; // userService.findUserEmailByCardNumber()
        payPalSystem.sendPayment(email, amount, currency);
    }
}
