package com.fedorowiat.accounts;

import com.fedorowiat.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Accounts {
    private  final List <User> users;
    private final Scanner input;


    public Accounts() {
        this.users  =  new ArrayList<>();
        this.input = new Scanner(System.in);
        this.users.add(new User(this.users.size() + 1, "admin", "tajne", true));
    }


    public void addUserAccount(){
            System.out.print("Podaj login: ");
            String login = this.input.nextLine();

            System.out.print("Podaj hasło: ");
            String password = this.input.nextLine();

            this.users.add(new User(this.users.size()+1,login,password,false));
    }

    public boolean checkLogin(String login) {
        for (User user: users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String password){
        for (User user: users) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPermission(String login){
        for (User user: users) {
            if(user.getLogin().equals(login)){
                return user.isPermissions();
            }
        }
        return false;
    }



}
