package dao;

import entities.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Comparator;
import java.util.List;

public class UserDaoImpl implements UserDao<UsersEntity, String> {
    private Session currentSession;
    private Transaction currentTransaction;

    public UserDaoImpl(){
    }

    @Override
    public void addUser(UsersEntity user) {
        getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(UsersEntity user) {
        getCurrentSession().delete(user);
    }

    @Override
    public void updateUser(UsersEntity user) {
        getCurrentSession().update(user);
    }

    @Override
    public UsersEntity getUserById(String userid) {
        int id = Integer.parseInt(userid);
        UsersEntity user = (UsersEntity) getCurrentSession().get(UsersEntity.class, id);
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UsersEntity> getAllUser() {
        List<UsersEntity> list = (List<UsersEntity>) getCurrentSession()
                .createQuery("from UsersEntity")
                .list();
        list.sort(Comparator.comparing(UsersEntity::getId));
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
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

}
