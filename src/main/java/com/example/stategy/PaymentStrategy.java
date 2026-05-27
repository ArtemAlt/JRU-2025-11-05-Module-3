package com.example.stategy;

interface PaymentStrategy {
    void pay(double amount);
    String getCode();
}
