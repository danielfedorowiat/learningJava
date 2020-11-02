package com.fedorowiat.user;

import com.fedorowiat.book.Book;
import java.util.List;

public final class User {
    private final Integer id;
    private final String login;
    private final String password;
    private final Boolean permissions;
    private final List<Book> borrowedBooks;

    public User(Integer id, String login, String password, Boolean permissions, List<Book> borrowedBooks) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.permissions = permissions;
        this.borrowedBooks = borrowedBooks;
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


    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
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
