package dao;

import java.io.Serializable;
import java.util.List;

public interface UserDaoHibernate<T, Id extends Serializable> extends UserDao<T, Id> {
    void addUser(T user);

    void updateUser(T user);

    void deleteUser(Id userId);

    T getUserById(Id id);

    T getUserByLogin(Id login);

    List<T> getAllUsers();
}
