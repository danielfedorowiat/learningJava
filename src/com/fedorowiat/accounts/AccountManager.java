package com.fedorowiat.accounts;

import com.fedorowiat.book.Book;
import com.fedorowiat.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class AccountManager {

    private final List<User> users;



    public AccountManager() {
        this.users = new ArrayList<>();
        this.users.add(new User(1, "admin", "tajne", true, new ArrayList<>()));
    }

    public boolean addUserAccount(String login, String password) {
        if (getUser(login).isPresent()) {
            return false;
        }else {
            this.users.add(new User(this.users.size() + 1, login, password, false, new ArrayList<>()));
            return true;
        }
    }

    public Optional<User> getUser(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean checkPermission(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user.isPermissions();
            }
        }
        return false;
    }


    public boolean checkAccount(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    public void showUsers(){
        for (User user: users) {
            System.out.println(user);
        }
    }


    public void showBorrowedBooksByTheUsers(){
        for (User user: users) {
           if(user.getBorrowedBooks() != null) {
               System.out.println("Użytkownik: "+user.getLogin());
               System.out.println("-----------------------------");
               for (Book book: user.getBorrowedBooks()) {
                   book.showBorrowedBooks();
                   System.out.println("\n\n");


           }
        }
    }
    }
}


