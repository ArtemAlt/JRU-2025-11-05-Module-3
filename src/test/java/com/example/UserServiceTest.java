package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserService service;

    @Test
    void findUserByName() {
        String expectedName = "Ivan";
        User expectedUser = new User(expectedName,"Ivanov", 30);
        Mockito.when(repository.findByName(expectedName))
                .thenReturn(Optional.of(expectedUser));

        User found = service.findByName(expectedName);
        assertEquals(expectedUser.getName(), found.getName());
        assertEquals(expectedUser.getAge(), found.getAge());
        assertEquals(expectedUser.getPassword(), found.getPassword());
    }

    @Test
    void saveUser() {
        String expectedName = "Ivan";
        User expectedUser = new User(expectedName,"Ivanov", 30);
        Mockito.when(repository.save(any(User.class)))
                .thenReturn(expectedUser);
        Mockito.when(repository.existsByName(expectedName))
                .thenReturn(Boolean.FALSE);

        User createdUser = service.create("Ivan", "Ivanov", 30);
        assertEquals(expectedUser.getName(), createdUser.getName());
        assertEquals(expectedUser.getAge(), createdUser.getAge());
        assertEquals(expectedUser.getPassword(), createdUser.getPassword());

    }

}