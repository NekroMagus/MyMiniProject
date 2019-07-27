package com.springcrud.service;

import com.springcrud.dao.SpringDataDao;
import com.springcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpringUserServiceImpl implements SpringUserService {

    private SpringDataDao dao;

    @Autowired
    public SpringUserServiceImpl(SpringDataDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void addUser(User user) {
        dao.saveAndFlush(user);
    }

    @Transactional
    public void deleteUser(long id) {
        dao.deleteById(id);
    }

    @Transactional
    public void updateUser(User user) {
        dao.saveAndFlush(user);
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
