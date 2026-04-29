package com.example.notification;

public class TelegramSender {
    public boolean isAvailable() {
        return false;
    }

    public void sendMessage(String tgId, String body) {
        System.out.println("Sending TG message to " + tgId + " with body " + body);
    }
}
