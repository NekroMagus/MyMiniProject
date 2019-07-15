package dao;

import entities.UsersEntity;

import java.util.List;

public interface UserDao {
    void addUser(UsersEntity user);

    void deleteUser(String userid);

    void updateUser(UsersEntity user);

    UsersEntity getUserById(String userid);

    List<UsersEntity> getAllUser();
}
