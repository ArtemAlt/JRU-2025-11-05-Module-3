package com.example;

public class SupportHandlerLevel3 extends SupportHandler {

    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getLevel() == 3;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("Processing Level 3 " + request.getIssue());
    }
}
