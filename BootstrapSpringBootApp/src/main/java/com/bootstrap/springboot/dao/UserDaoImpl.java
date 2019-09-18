package com.bootstrap.springboot.dao;

import com.bootstrap.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    @Override
    public void insert(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Transactional
    @Override
    public void update(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    @Transactional
    @Override
    public void removeById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
        em.close();
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(User.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByLogin(String login) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = (User) em.createQuery("SELECT u from User u where u.login=:login")
                .setParameter("login", login)
                .getSingleResult();
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> userList = em.createQuery("SELECT u from User u", User.class)
                .getResultList();
        return userList;
    }
}
