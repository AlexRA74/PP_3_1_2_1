package ru.javamentor.springmvc.service;


import jakarta.validation.Valid;
import ru.javamentor.springmvc.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void removeUser(Long id);
    void updateUser(@Valid User user);
}
