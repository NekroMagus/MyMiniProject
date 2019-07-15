package dao;

import db.DbService;
import entities.UsersEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection;

    public UserDaoImpl() {
        this.connection = DbService.getMysqlConnection();
    }

    @Override
    public void addUser(UsersEntity user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name) values (?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String userid) {
        try {
            int id = Integer.parseInt(userid);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(UsersEntity user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set name =? where id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UsersEntity getUserById(String userid) {
        UsersEntity user = new UsersEntity();
        try{
            int id = Integer.parseInt(userid);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setId(id);
                user.setName(resultSet.getString("name"));
            }
        } catch(SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<UsersEntity> getAllUser() {
        List<UsersEntity> allUser = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                UsersEntity user = new UsersEntity();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                allUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        allUser.sort(Comparator.comparing(UsersEntity::getId));
        return allUser;
    }


}
