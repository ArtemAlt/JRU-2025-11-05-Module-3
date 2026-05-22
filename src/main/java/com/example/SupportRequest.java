package com.example;

public class SupportRequest {
    private String issue;
    private int level;
    public SupportRequest(String issue, int level) {
        this.issue = issue;
        this.level = level;
    }

    public String getIssue() {
        return issue;
    }

    public int getLevel() {
        return level;
    }
}
