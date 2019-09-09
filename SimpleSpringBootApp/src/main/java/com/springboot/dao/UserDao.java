package com.springboot.dao;

import com.springboot.domain.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void updateUser(User user);

    void deleteById(Long id);

    User findById(Long id);

    User findByLogin(String login);

    List<User> findAll();

}