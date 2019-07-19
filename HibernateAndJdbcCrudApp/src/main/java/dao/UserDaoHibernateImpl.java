package dao;

import db.DBHelper;
import entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Comparator;
import java.util.List;

public class UserDaoHibernateImpl extends UserDaoFactory implements UserDaoHibernate<UserEntity, String> {
    private Session currentSession;
    private Transaction currentTransaction;

    private static Configuration configuration;

    public UserDaoHibernateImpl() {
        configuration = DBHelper.getInstance().getConfiguration();
    }


    @Override
    public void addUser(UserEntity user) {
        openCurrentSessionwithTransaction();
        getCurrentSession().save(user);
        closeCurrentSessionwithTransaction();
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity user = getUserById(userId);
        openCurrentSessionwithTransaction();
        getCurrentSession().delete(user);
        closeCurrentSessionwithTransaction();
    }

    @Override
    public void updateUser(UserEntity user) {
        openCurrentSessionwithTransaction();
        getCurrentSession().update(user);
        closeCurrentSessionwithTransaction();
    }

    @Override
    public UserEntity getUserById(String userid) {
        openCurrentSession();
        long id = Long.parseLong(userid);
        UserEntity user = (UserEntity) getCurrentSession().get(UserEntity.class, id);
        closeCurrentSession();
        return user;
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        openCurrentSession();
        List<UserEntity> list = (List<UserEntity>) getCurrentSession()
                .createQuery("from UserEntity")
                .list();
        UserEntity user = null;
        for (UserEntity e : list) {
            if (e.getLogin().equals(login)) {
                user = e;
            }
        }
        closeCurrentSession();
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUsers() {
        openCurrentSession();
        List<UserEntity> list = (List<UserEntity>) getCurrentSession()
                .createQuery("from UserEntity")
                .list();
        list.sort(Comparator.comparing(UserEntity::getId));
        closeCurrentSession();
        return list;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
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
}