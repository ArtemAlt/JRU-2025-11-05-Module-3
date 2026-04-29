package com.example;

public class UserService {

    private final  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByName(String name){
        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(String name, String password, Integer age) {
        if (userRepository.existsByName(name)) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User(name, password, age);
        return userRepository.save(user);
    }
}
