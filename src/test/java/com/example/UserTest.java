package com.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void initUser() {
        User user = new User("Mark","654368", 20);
        assertAll("Check user init",
                () -> assertEquals("Mark", user.getName()),
                () -> assertEquals("654368", user.getPassword()),
                () -> assertEquals(201, user.getAge())
        );
    }

    @Test
    void checkTimer() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(1000);
        });
    }
}