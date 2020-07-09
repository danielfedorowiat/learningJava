package com.fedorowiat.user;

public final class User {
    private final Integer id;
    private final String login;
    private final String password;
    private final Boolean permissions;

    public User(Integer id, String login, String password, Boolean permissions) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.permissions = permissions;
    }

    public int getId() {
        return id;
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
}
