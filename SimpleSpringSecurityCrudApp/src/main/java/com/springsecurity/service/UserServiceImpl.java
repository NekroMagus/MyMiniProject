package com.springsecurity.service;

import com.springsecurity.dao.DAO;
import com.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final DAO dao;

    @Autowired
    public UserServiceImpl(DAO dao) {
        this.dao = dao;
    }

    @Transactional
    public void addUser(User user) {
        dao.insert(user);
    }
    @Transactional
    public void updateUser(User user) {
        dao.update(user);
    }
    @Transactional
    public void deleteUserById(Long id) {
        dao.delete(id);
    }
    @Transactional
    public User findUserById(Long id) {
        return (User) dao.findById(id);
    }
    @Transactional
    public List<User> findAllUsers() {
        return dao.findAll();
    }
}
