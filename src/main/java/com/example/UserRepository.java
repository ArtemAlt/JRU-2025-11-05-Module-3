package com.example;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByName(String name);

    User save(User user);

    Boolean existsByName(String name);
}
