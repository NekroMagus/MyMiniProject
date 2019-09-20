package com.ajax.bootstrap.dao.impl;

import com.ajax.bootstrap.dao.UserDao;
import com.ajax.bootstrap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    @Override
    public void addUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByLogin(String login) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = (User) em.createQuery("SELECT u FROM User u where login=:login")
                .setParameter("login",login)
                .getSingleResult();
        em.close();
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = em.find(User.class,id);
        em.close();
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return userList;
    }
}
