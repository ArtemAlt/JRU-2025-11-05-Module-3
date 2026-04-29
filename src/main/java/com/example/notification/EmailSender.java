package com.example.notification;

public class EmailSender {
    public boolean isAvailable() {
        return true;
    }

    public void sendEmail(String subject, String body, String mail) {
        System.out.println("Sending email...");
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("Mail: " + mail);
    }
}
