package com.example.stategy;

import java.util.ArrayList;
import java.util.List;

public class PaymentSelector {
    private final List<PaymentStrategy> paymentStrategies = new ArrayList<>();

    public PaymentStrategy selectPaymentStrategy(String code) {
        return paymentStrategies.stream()
                .filter(strategy -> strategy.getCode().equals(code)).
                findFirst()
                .get();
    }
}
