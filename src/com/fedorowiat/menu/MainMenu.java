package com.fedorowiat.menu;

import com.fedorowiat.accounts.Accounts;
import com.fedorowiat.library.Library;

import java.util.Scanner;

public class MainMenu {
    private final Scanner input;
    private final LoginMenu loginMenu;
    private final Accounts accounts;
    private final Boolean m1 = true;


    public MainMenu() {
        this.accounts = new Accounts();
        this.input = new Scanner(System.in);
        this.loginMenu = new LoginMenu(this.accounts);
    }

    public void showMainMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println(" __________________\n" +
                    "|Witaj w bibliotece|\n" +
                    "|##################|\n" +
                    "|1.Logowanie       |\n" +
                    "|2.Rejestracja     |\n" +
                    "|3.Zakończ         |\n" +
                    " ------------------");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    loginMenu.showLoginMenu();
                    break;
                }
                case 2: {
                    if(accounts.addUserAccount()){
                        System.out.println("Pomyślnie utworzono konto");
                    }else{
                        System.out.println("Podany login juz istnieje!");
                    }
                    break;
                }
                case 3: {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("Nie wybrano prawidlowej opcji!");
                    break;
                }
            }
        }
    }


}
