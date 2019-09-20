package com.ajax.bootstrap.dao;

import com.ajax.bootstrap.domain.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    User findUserByLogin(String login);

    User findUserById(Long id);

    List<User> findAllUsers();

}
