package com.example;

public class PizzaMushroomDecorator extends PizzaDecorator {

    public PizzaMushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " add Mushroom";
    }

    @Override
    public double getPrice() {
        return decoratedPizza.getPrice() + 50;
    }
}
