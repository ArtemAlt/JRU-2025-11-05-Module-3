package com.example.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User sender) {
        broadcast(message, sender);
        System.out.println("Sending message: " + message + " from sender: " + sender);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println("User " + user.name + " connected");
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
        System.out.println("User " + user.name + " disconnected");
    }

    private void broadcast(String message, User sender) {
        for (User user : users) {
            user.receiveMessage(message, sender != null ? sender.name : "System");
        }
    }
}
