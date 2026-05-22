package com.example;

public class MusicCenter {
    private Boolean isOn;

    public void turnOn(){
        isOn = true;
        System.out.println("Music ON");
    }

    public void turnOff(){
        isOn = false;
        System.out.println("Music OFF");
    }
}
