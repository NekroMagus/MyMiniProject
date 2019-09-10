package com.bootstrap.springboot.service;

import com.bootstrap.springboot.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    User findUserById(Long id);

    User findUserByLogin(String login);

    List<User> findAllUsers();
}
