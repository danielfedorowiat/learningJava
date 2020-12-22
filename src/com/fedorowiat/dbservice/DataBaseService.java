package com.fedorowiat.dbservice;

import com.fedorowiat.user.User;
import java.sql.*;
import java.util.Scanner;

public class DataBaseService implements DataBase {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "password";
    private PreparedStatement statement;
    private Scanner scanner;
    private User user;


    public DataBaseService(){
        this.scanner = new Scanner(System.in);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", USERNAME, PASSWORD);
    }

    @Override
    public void registerAccount() {
        try {
            if (setUser()) {
                Connection connection = getConnection();
                statement = connection.prepareStatement("insert into users (email,lastname,firstname,password,permission) values (?,?,?,?,?::permission)");
                statement.setString(1, "" + user.getLogin());
                statement.setString(2, "" + user.getFirstName());
                statement.setString(3, "" + user.getLastName());
                statement.setString(4, "" + user.getPassword());
                statement.setString(5, "" + user.getPermissions());
                statement.executeUpdate();
                System.out.println("Konto zostało pomyślnie utworzone.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkEmail(){

        try {
            Connection connection = getConnection();
            statement = connection.prepareStatement("select * from users where (email) = (?)");
            statement.setString(1, "" + user.getLogin());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

//    public User getUser(String username) {
//        try {
//            Connection connection = getConnection();
//            statement = connection.prepareStatement("select * from users where email = ?");
//            statement.setString(1, username);
//            ResultSet resultSet =  statement.executeQuery();
//            if (resultSet.next()){
//                return mapToUser(resultSet);
//            }
//            return null;
//        } catch (SQLException e) {
//            System.out.println("Huj kurwa jeblo bledem: " + e.getMessage());
//            return null;
//        }
//    }
//
//    private User mapToUser(ResultSet result) throws SQLException {
//        User target = new User();
//        target.setId(result.getInt("user_id"));
//        target.setLogin(result.getString("email"));
//        return target;
//    }
//
    private boolean setUser() {
        boolean isCorrect = true;
        String password = null;
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();
        this.user = new User(login, "", "", "", false);
        if (checkEmail()) {
            System.out.println("Email already exist!");
            this.user = null;
            registerAccount();
        } else {
            System.out.println("Podaj imię: ");
            String firstName = scanner.nextLine();

            System.out.println("Podaj nazwisko: ");
            String lastName = scanner.nextLine();

            while (isCorrect) {
                System.out.println("Podaj hasło: ");
                String password_1 = scanner.nextLine();

                System.out.println("Podaj ponownie hasło: ");
                String password_2 = scanner.nextLine();

                if (password_1.equals(password_2)) {
                    password = password_2;
                    this.user.setFirstName(firstName);
                    this.user.setLastName(lastName);
                    this.user.setPassword(password);
                    return true;
                }
            }
        }
        return false;
    }
}
