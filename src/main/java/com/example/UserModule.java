package com.example;

import com.example.models.User;
// High Cohesion
public class UserModule {
    public void registerNewUser(User user) {}
    public void sendEmail(User user) {}
    public void calculateDiscount(User user) {}
}
