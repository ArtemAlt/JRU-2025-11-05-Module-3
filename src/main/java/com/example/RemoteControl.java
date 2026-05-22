package com.example;

public class RemoteControl {
    private Command [] buttons = new Command[7];

    public void setCommand(Command command, int slot) {
        buttons[slot] = command;
    }

    public void pressButton(int slot) {
        if (buttons[slot] != null) {
            buttons[slot].execute();
        } else {
            System.out.println("No button");
        }
    }
}
