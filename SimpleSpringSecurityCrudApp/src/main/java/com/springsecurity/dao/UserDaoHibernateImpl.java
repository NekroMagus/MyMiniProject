package com.springsecurity.dao;

import com.springsecurity.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements DAO<User> {

    private Session currentSession;
    private Transaction currentTransaction;
    private static Configuration configuration;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

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

    public void delete(Long userId) {
        User user = findById(userId);
        openCurrentSessionwithTransaction();
        getCurrentSession().delete(user);
        closeCurrentSessionwithTransaction();
    }

    public User findById(Long id) {
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

    public Configuration getConfiguration() {
        configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", JDBC_URL);
        configuration.setProperty("hibernate.connection.username", LOGIN);
        configuration.setProperty("hibernate.connection.password", PASSWORD);
        configuration.setProperty("show_sql", "false");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }
}
