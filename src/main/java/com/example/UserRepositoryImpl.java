package com.example;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findByName(String name) {
        /*
        fing BD
        OPEN connection
        LOGIN PASSWORD
         */
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Boolean existsByName(String name) {
        return null;
    }
}
