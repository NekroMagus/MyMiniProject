package com.simple.security.service;

import com.simple.security.dao.UserDao;
import com.simple.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public void addUser(User user) {
        dao.save(user);
    }

    public void updateUser(User user) {
        dao.save(user);
    }

    public void deleteUser(long id) {
        dao.delete(dao.findById(id).get());
    }

    @Override
    public User findUserById(Long id) {
        return dao.findById(id).get();
    }

    public User findUserByLogin(String login) {
        return dao.findByLogin(login);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
