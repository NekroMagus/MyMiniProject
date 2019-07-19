package service;

import dao.UserDao;
import dao.UserDaoFactory;
import entities.UserEntity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public final class UserService {

    private UserDao dao;
    private static UserService instance;

    private UserService() {
        addProperties();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void addProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\fli_i.LAPTOP-F81S9FK5\\IdeaProjects\\HibernateAndJdbcCrudApp\\src\\main\\resources\\factory.properties");
            properties.load(in);
            if (properties.getProperty("userDao").equalsIgnoreCase("Hibernate")) {
                dao = UserDaoFactory.createUserDaoHibernate();
            } else if (properties.getProperty("userDao").equalsIgnoreCase("JDBC")) {
                dao = UserDaoFactory.createUserDaoJDBC();
            } else {
                throw new RuntimeException("Wrong property");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(UserEntity user) {
        dao.addUser(user);
    }

    public void updateUser(UserEntity user) {
        dao.updateUser(user);
    }

    public void deleteUser(String userId) {
        dao.deleteUser(userId);
    }

    public UserEntity getUserById(String userId) {
        return (UserEntity) dao.getUserById(userId);
    }

    public UserEntity getUserByLogin(String login) {
        return (UserEntity) dao.getUserByLogin(login);
    }

    public List<UserEntity> getAllUsers() {
        return dao.getAllUsers();
    }
}
