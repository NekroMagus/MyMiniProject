package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entities.UsersEntity;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public void addUser(UsersEntity user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String userid) {
        dao.deleteUser(userid);
    }

    @Override
    public void updateUser(UsersEntity user) {
        dao.updateUser(user);
    }

    @Override
    public UsersEntity getUserById(String id) {
        return dao.getUserById(id);
    }

    @Override
    public List<UsersEntity> getAllUser() {
        return dao.getAllUser();
    }
}
