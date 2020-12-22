package com.fedorowiat.user;

import com.fedorowiat.book.Book;
import java.util.List;

public class User {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private Boolean permissions;


    public User(String login,String firstName, String lastName, String password, Boolean permissions) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.permissions = permissions;
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

    public void setPermissions(Boolean permissions) {
        this.permissions = permissions;
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

    public Boolean getPermissions() {
        return permissions;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public boolean isPermissions() {
        return permissions;
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
                ", permissions=" + permissions +
                '}';
    }

}
