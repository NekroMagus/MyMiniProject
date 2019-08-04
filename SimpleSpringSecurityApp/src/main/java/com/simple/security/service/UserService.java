package com.simple.security.service;

import com.simple.security.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    public User findUserById(Long id);

    User findUserByLogin(String login);

    List<User> findAll();

}
