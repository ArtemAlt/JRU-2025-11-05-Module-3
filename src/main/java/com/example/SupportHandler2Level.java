package com.example;

public class SupportHandler2Level extends SupportHandler {

    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getLevel() == 2;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("Processing Level 2 " + request.getIssue());
    }
}
