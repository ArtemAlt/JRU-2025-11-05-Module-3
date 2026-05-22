package com.example;

public class SupportHandler1Level extends SupportHandler {

    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getLevel() <= 1;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("Processing Level 1 " + request.getIssue());
    }
}
