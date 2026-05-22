package com.example;

public abstract class SupportHandler {
    protected SupportHandler next;

    public void handle(SupportRequest request) {
        if (canHandle(request)){
            process(request);
        } else if (next != null) {
            System.out.println("Send to next level");
            next.handle(request);
        } else {
            System.out.println("Nothing to process");
        }
    }

    protected abstract boolean canHandle(SupportRequest request);
    protected abstract void process(SupportRequest request);

    public void setNext(SupportHandler next) {
        this.next = next;
    }
}
