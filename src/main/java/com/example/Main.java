package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        log.trace("Самая детальная информация (обычно не видна)");
//        log.debug("Информация для отладки");
//        log.info("Приложение запущено");
//        log.warn("Что-то пошло не так, но мы справились");
//        log.error("Произошла ошибка!", new RuntimeException("Тестовая ошибка"));
        // TRACE - DEBUG - INFO - WARN - ERROR - FATAL
//        UserService userService = new UserService();
//        userService.createUser("admin", null);

        log.info("Starting bank account");

        BankAccount bankAccount = new BankAccount("Ivanov");

        bankAccount.deposit(100.0);
        bankAccount.deposit(1000.0);
        bankAccount.deposit(500.5);
        try {
            bankAccount.withdraw(600.0);
        } catch (Exception e) {
            log.error("Operation not compete", e);
        }

        try {
            bankAccount.deposit(-600.0);
        } catch (Exception e) {
            log.error("Operation not compete", e);
        }

        try {
            bankAccount.withdraw(-600.0);
        } catch (Exception e) {
            log.error("Operation not compete", e);
        }
        bankAccount.getBalance();
        log.info("Ending bank account");
        /*
log.debug("User " + userId + " logged in");
log.debug("User {} logged in", userId);
log.info("User {} with email {} logged in at {}", userId, email, timestamp);
log.error("Failed to process user {}", userId, exception);
         */
    }
}