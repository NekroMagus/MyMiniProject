package com.bootstrap.springboot.dao;

import com.bootstrap.springboot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void insert(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public User findUserByLogin(String login) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
