package com.example;

public class LighCommand implements Command {
    private Light light;

    public LighCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
