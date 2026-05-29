package com.example.mediator;

abstract class User {
    protected String name;
    protected ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addUser(this);
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message, String from);
}
