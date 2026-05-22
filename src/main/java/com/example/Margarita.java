package com.example;

public class Margarita implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza Margarita ";
    }

    @Override
    public double getPrice() {
        return 650;
    }
}
