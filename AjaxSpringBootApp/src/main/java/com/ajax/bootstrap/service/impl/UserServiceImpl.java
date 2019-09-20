package com.ajax.bootstrap.service.impl;

import com.ajax.bootstrap.repository.UserDao;
import com.ajax.bootstrap.domain.User;
import com.ajax.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        dao.deleteUserById(id);
    }

    @Override
    public User findUserByLogin(String login) {
        return dao.findUserByLogin(login);
    }

    @Override
    public User findUserById(Long id) {
        return dao.findUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
}
