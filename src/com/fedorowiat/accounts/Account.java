package com.fedorowiat.accounts;

import com.fedorowiat.user.User;

import java.util.Optional;

public interface Account {
    boolean addUserAccount(String login, String password);
    void addNewUser();
    Optional<User> getUser(String login);
    boolean checkPermission(String login);
    boolean checkAccount(String login, String password);
    void showUsers();
    void showBorrowedBooksByTheUsers();
}
