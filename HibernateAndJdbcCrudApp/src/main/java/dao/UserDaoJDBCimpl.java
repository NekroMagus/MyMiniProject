package dao;

import db.DBHelper;
import entities.UserEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDaoJDBCimpl extends UserDaoFactory implements UserDaoJDBC<UserEntity, String> {

    private Connection connection;

    public UserDaoJDBCimpl() {
        this.connection = DBHelper.getInstance().getConnection();
    }

    @Override
    public void addUser(UserEntity user) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users_with_role(login,password) values(?,?)");
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(UserEntity user) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE users_with_role SET name = ? WHERE id = ?");
            stmt.setString(1, user.getLogin());
            stmt.setLong(2, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(String id) {
        UserEntity user = getUserById(id);
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM users_with_role where id = ?");
            stmt.setLong(1, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserEntity getUserById(String userId) {
        UserEntity user = new UserEntity();
        try {
            long id = Long.parseLong(userId);
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users_with_role where id = ?");
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user.setId(id);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        UserEntity user = new UserEntity();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users_with_role WHERE login = ?");
            stmt.setString(1, login);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM users_with_role");
            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.sort(Comparator.comparing(UserEntity::getId));
        return list;
    }
}
