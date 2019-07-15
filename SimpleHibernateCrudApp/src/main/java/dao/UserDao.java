package dao;

import entities.UsersEntity;

import java.io.Serializable;
import java.util.List;

public interface UserDao<T, Id extends Serializable> {
    void addUser(T user);

    void deleteUser(T user);

    void updateUser(T user);

    UsersEntity getUserById(Id userid);

    List<UsersEntity> getAllUser();
}
