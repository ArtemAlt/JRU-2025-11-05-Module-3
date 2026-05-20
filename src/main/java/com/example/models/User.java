package com.example.models;
//Model
public class User {
    private String name;
    private String password;
    private Integer age;

    public User(String name, String password, Integer age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }
}
