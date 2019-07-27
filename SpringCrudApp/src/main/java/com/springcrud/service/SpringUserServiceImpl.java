package com.springcrud.service;

import com.springcrud.dao.SpringDataDao;
import com.springcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class SpringUserServiceImpl implements SpringUserService{

    private final SpringDataDao dao;

    public SpringUserServiceImpl(SpringDataDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void addUser(User user) {
        dao.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        dao.delete(findUserById(id));
    }

    @Transactional
    public void updateUser(User user) {
        User us = dao.findById(user.getId()).get();
        if(us != null) {
            dao.save(us);
        }
    }

    @Transactional
    public User findUserById(long id) {
        return dao.findById(id).get();
    }

    @Transactional
    public List<User> findAllUsers() {
        return dao.findAll();
    }
}
