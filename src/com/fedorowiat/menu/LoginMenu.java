package com.fedorowiat.menu;

import com.fedorowiat.accounts.Accounts;

import java.util.Scanner;

public class LoginMenu {

    private final Accounts accounts ;
    private final Scanner input ;

    public LoginMenu(final  Accounts accounts) {
        this.accounts = accounts;
        this.input = new Scanner(System.in);
    }

    public void showLoginMenu(){
        System.out.print("Podaj login: ");
        String login = input.nextLine();

        System.out.print("Podaj hasło: ");
        String password = input.nextLine();

        if(accounts.checkLogin(login) && accounts.checkPassword(password)){
            if(accounts.checkPermission(login)){
                System.out.println("Konto admina.");
            }else {
                System.out.println("Konto użytkownika.");
            }
        }else{
            System.out.println("Błędny login lub hasło");
        }


    }

}
