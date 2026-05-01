package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);

    public void createUser(String name, String email) {
        /*
        name + @mail.ru
         */
        log.debug("Creating user with name {} and email {}", name, email);
        try {
            if (email == null || email.isEmpty()) {
                log.warn("Email is null or empty");
                throw new IllegalArgumentException("Email is null or empty");
            }
            /*
            create user
             */
            log.info("Creating user with name {} and email {}", name, email);

        } catch (Exception e) {
            log.error("Error creating user with name {} and email {}", name, email, e);
        }
        log.debug("Created user with name {} and email {}", name, email);
    }
}
