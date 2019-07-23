package service;

import dao.UserDaoImpl;

import entities.UsersEntity;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl dao;

    public UserServiceImpl(){
        this.dao = new UserDaoImpl();
    }

    @Override
    public void addUser(UsersEntity user) {
        dao.openCurrentSessionwithTransaction();
        dao.addUser(user);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void deleteUser(String userid) {
        dao.openCurrentSessionwithTransaction();
        UsersEntity user = dao.getUserById(userid);
        dao.deleteUser(user);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void updateUser(UsersEntity user) {
        dao.openCurrentSessionwithTransaction();
        dao.updateUser(user);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public UsersEntity getUserById(String id) {
        dao.openCurrentSession();
        UsersEntity user = new UsersEntity(id);
        dao.closeCurrentSession();
        return user;
    }

    @Override
    public List<UsersEntity> getAllUser() {
        dao.openCurrentSession();
        List<UsersEntity> list = dao.getAllUser();
        dao.closeCurrentSession();
        return list;
    }
}
