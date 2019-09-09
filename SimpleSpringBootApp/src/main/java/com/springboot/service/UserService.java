package com.springboot.service;

import com.springboot.domain.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    void deleteById(Long id);

    User findByLogin(String login);

    User findById(Long id);

    List<User> findAll();
}
