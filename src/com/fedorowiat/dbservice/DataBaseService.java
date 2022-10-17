package com.fedorowiat.dbservice;

import com.fedorowiat.exception.UserNotFoundException;
import com.fedorowiat.user.User;
import com.fedorowiat.user.UserType;

import java.sql.*;

public class DataBaseService implements DataBase {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "password";


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", USERNAME, PASSWORD);
    }

    @Override
    public void saveUser(User user) {
        try (var connection = getConnection();
             var statement = createPreparedStatementForSaveUser(connection, user);
        ) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private PreparedStatement createPreparedStatementForSaveUser(Connection connection, User user) throws SQLException {
        var sql = "INSERT INTO users (email, last_name, first_name, password, access_level) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "" + user.getLogin());
        preparedStatement.setString(2, "" + user.getFirstName());
        preparedStatement.setString(3, "" + user.getLastName());
        preparedStatement.setString(4, "" + user.getPassword());
        preparedStatement.setString(5, "" + UserType.USER.name());
        return preparedStatement;
    }

    public boolean checkEmailIsExist(String email) {
        try (var connection = getConnection();
             var statement = createPreparedStatementForCheckEmailIsExist(connection, email);
             var resultSet = statement.executeQuery();) {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    private PreparedStatement createPreparedStatementForCheckEmailIsExist(Connection connection, String email) throws SQLException {
        var sql = "SELECT * FROM users WHERE (Email) = (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "" + email);
        return preparedStatement;
    }


    public String getAccessLevel(String login, String password) throws UserNotFoundException {
        try (var connection = getConnection();
             var statement = createPreparedStatementForGetAccessLevel(connection, login, password);
             var resultSet = statement.executeQuery();) {
            if (resultSet.next()) {
                return resultSet.getString("access_level");
            }
            throw new UserNotFoundException();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new UserNotFoundException();
        }


    }


    private PreparedStatement createPreparedStatementForGetAccessLevel(Connection connection, String login, String password) throws SQLException {
        var sql = "SELECT access_level FROM users WHERE (email,password) = (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "" + login);
        preparedStatement.setString(2, "" + password);
        return preparedStatement;
    }

}
