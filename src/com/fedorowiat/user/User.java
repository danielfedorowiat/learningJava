package com.fedorowiat.user;



public class User {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private UserType userType;


    public User(String login,String firstName, String lastName, String password, UserType userType) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getId() {
        return id;
    }

    public UserType getPermissions() {
        return userType;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public UserType getUserType() {
        return userType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + userType +
                '}';
    }

}
