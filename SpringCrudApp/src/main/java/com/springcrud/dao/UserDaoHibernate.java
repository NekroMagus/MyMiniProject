package com.springcrud.dao;

import com.springcrud.model.User;

import java.util.List;

public interface UserDaoHibernate extends Dao<User> {

    void insert(User user);

    void update(User user);

    void delete(long userId);

    User findById(long id);

    List<User> findAll();
}
