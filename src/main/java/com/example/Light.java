package com.example;

public class Light {
    private  String location;
    private Boolean isOn;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn(){
        isOn = true;
        System.out.println("In " + location + " light ON");
    }

    public void turnOff(){
        isOn = false;
        System.out.println("In " + location + " light OFF");
    }
}
