package dao;

import java.util.List;

public interface UserDao<T, Id> {
    void addUser(T user);

    void updateUser(T user);

    void deleteUser(Id userId);

    T getUserById(Id id);

    T getUserByLogin(Id login);

    List<T> getAllUsers();

}
