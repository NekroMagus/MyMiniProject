package com.bootstrap.springboot.dao;

import com.bootstrap.springboot.domain.User;

import java.util.List;

public interface UserDao {

    void insert(User user);

    void update(User user);

    void removeById(Long id);

    User findUserById(Long id);

    User findUserByLogin(String login);

    List<User> findAllUsers();
}
