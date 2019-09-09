package com.springboot.dao;

import com.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    @Override
    public void save(User user) {
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
    public void deleteById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
        em.close();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(User.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByLogin(String login) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = (User) em.createQuery("SELECT u FROM User u where u.login=:login")
                .setParameter("login", login)
                .getSingleResult();
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        return userList;
    }
}
