package com.simple.springmvc.service;

import com.simple.springmvc.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUserById(long id);

    void updateUser(User user);

    User findUserByLogin(String login);

    User findUserById(long id);

    List<User> getAllUsers();
}
