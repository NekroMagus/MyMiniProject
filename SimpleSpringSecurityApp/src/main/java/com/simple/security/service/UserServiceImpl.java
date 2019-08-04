package com.simple.security.service;

import com.simple.security.dao.UserDao;
import com.simple.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    public void addUser(User user){dao.save(user);}

    public void updateUser(User user) {dao.save(user);}

    public void deleteUser(long id){dao.delete(dao.findById(id).get());}

    public List<User> findAll() {return dao.findAll();}
}
