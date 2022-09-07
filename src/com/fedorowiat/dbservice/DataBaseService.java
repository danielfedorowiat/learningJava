package com.fedorowiat.dbservice;

import com.fedorowiat.user.User;

import java.sql.*;
import java.util.Scanner;

public class DataBaseService implements DataBase {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "password";
    private PreparedStatement statement;


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", USERNAME, PASSWORD);
    }

    @Override
    public void saveUser(User user) {
        try {
            Connection connection = getConnection();
            statement = connection.prepareStatement("insert into users (email,lastname,firstname,password,permission) values (?,?,?,?,?::permission)");
            statement.setString(1, "" + user.getLogin());
            statement.setString(2, "" + user.getFirstName());
            statement.setString(3, "" + user.getLastName());
            statement.setString(4, "" + user.getPassword());
            statement.setString(5, "" + user.getPermissions());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public boolean checkEmailIsExist(String email) {

        try {
            Connection connection = getConnection();
            statement = connection.prepareStatement("select * from users where (email) = (?)");
            statement.setString(1, "" + email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.isBeforeFirst();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
