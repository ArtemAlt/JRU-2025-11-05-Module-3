package com.example.notification;

public class NotificationService {
    private final EmailSender emailSender;
    private final TelegramSender telegramSender;

    public NotificationService(EmailSender emailSender, TelegramSender telegramSender) {
        this.emailSender = emailSender;
        this.telegramSender = telegramSender;
    }

    public SentMessage sendEmail(String userName) {
        if (!emailSender.isAvailable()){
            /*
            Delay (5)
            retry
             */
            throw new RuntimeException("Email Server not available");
        }
        String subject = "Notification";
        String body = "Hello " + userName;
        String mail = userName + "@example.com";

        emailSender.sendEmail(subject, body, mail);
        return new SentMessage(subject, body, mail, null);
    }

    public SentMessage sesMessage(String name){
        if (!telegramSender.isAvailable()){
            throw new RuntimeException("Email Server not available");
        }
        String body = "Hello " + name;
        String tgId = "@" +name;

        telegramSender.sendMessage(tgId, body);
        return new SentMessage(null, null, body, tgId);
    }
}
