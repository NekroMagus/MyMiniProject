package com.springcrud.dao;

import com.springcrud.db.DBHelper;
import com.springcrud.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDaoHibernate {

    private Session currentSession;
    private Transaction currentTransaction;
    private static Configuration configuration;

    public UserDaoHibernateImpl() {
        configuration = DBHelper.getInstance().getConfiguration();
    }

    public void insert(User user) {
        openCurrentSessionwithTransaction();
        getCurrentSession().persist(user);
        closeCurrentSessionwithTransaction();
    }

    public void update(User user) {
        openCurrentSessionwithTransaction();
        getCurrentSession().update(user);
        closeCurrentSessionwithTransaction();
    }

    public void delete(long userId) {
        User user = findById(userId);
        openCurrentSessionwithTransaction();
        getCurrentSession().delete(user);
        closeCurrentSessionwithTransaction();
    }

    public User findById(long id) {
        openCurrentSession();
        User user = (User) getCurrentSession().get(User.class, id);
        closeCurrentSession();
        return user;
    }

    public List<User> findAll() {
        openCurrentSession();
        List<User> list = getCurrentSession().createQuery("from User").list();
        list.sort(Comparator.comparing(User::getId));
        closeCurrentSession();
        return list;
    }

    private static SessionFactory getSessionFactory() {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

}
