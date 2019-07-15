package service;

import entities.UsersEntity;

import java.util.List;

public interface UserService {
    void addUser(UsersEntity user);

    void deleteUser(String userid);

    void updateUser(UsersEntity user);

    UsersEntity getUserById(String id);

    List<UsersEntity> getAllUser();
}
