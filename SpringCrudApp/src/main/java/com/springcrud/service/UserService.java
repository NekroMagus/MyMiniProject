package com.springcrud.service;

import com.springcrud.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    User findUserById(long id);

    List<User> findAllUsers();
}
