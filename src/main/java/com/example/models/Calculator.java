package com.example.models;

public class Calculator {
    private int lastResult;

    public int add(int a, int b) {
        lastResult = a + b;
        return lastResult;
    }

    public int subtract(int a, int b) {
        lastResult = a - b;
        return lastResult;
    }

    public int multiply(int a, int b) {
        lastResult = a * b;
        return lastResult;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("На ноль делить нельзя!");
        }
        lastResult = a / b;
        return lastResult;
    }

    public int getLastResult() {
        return lastResult;
    }
}
