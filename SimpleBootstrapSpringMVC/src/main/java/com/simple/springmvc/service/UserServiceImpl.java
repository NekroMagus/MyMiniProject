package com.simple.springmvc.service;

import com.simple.springmvc.dao.UserDao;
import com.simple.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userDao.delete(findUserById(id));
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
