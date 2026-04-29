package com.example.notification;

public class SentMessage {
    private String subject;
    private String body;
    private String mail;
    private String tgt;

    public SentMessage(String subject, String body, String mail, String tgt) {
        this.subject = subject;
        this.body = body;
        this.mail = mail;
        this.tgt = tgt;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getMail() {
        return mail;
    }

    public String getTgt() {
        return tgt;
    }
}
