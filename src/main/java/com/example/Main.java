package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServiceLocator.register(DiscountService.class, new DiscountService());
        ServiceLocator.register(EmailService.class, new EmailService());
        ServiceLocator.register(DiscountService.class, new DiscountService());


        // FIRST - TDD
        // TRIPLE A -
        // Single
    }
}