package com.example.mediator;

public class ChatUser extends User {
    public ChatUser(String name, ChatMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message, String from) {
        System.out.println("User: "+ this.name +" Received message: " + message + " from: " + from);
    }
}
