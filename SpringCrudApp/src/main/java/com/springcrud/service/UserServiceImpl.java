package com.springcrud.service;

import com.springcrud.dao.UserDaoHibernate;
import com.springcrud.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService {

    private final UserDaoHibernate dao;

    // @Autowired
    public UserServiceImpl(UserDaoHibernate dao) {
        this.dao = dao;
    }

    @Transactional
    public void addUser(User user) {
        dao.insert(user);
    }

    @Transactional
    public void deleteUser(long id) {
        dao.delete(id);
    }

    @Transactional
    public void updateUser(User user) {
        dao.update(user);
    }

    @Transactional
    public User findUserById(long id) {
        return dao.findById(id);
    }

    @Transactional
    public List<User> findAllUsers() {
        return dao.findAll();
    }
}
