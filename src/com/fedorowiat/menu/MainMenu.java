package com.fedorowiat.menu;


import com.fedorowiat.accounts.AccountManager;
import com.fedorowiat.library.Library;

import java.util.Scanner;

public class MainMenu {
    private final Scanner input;
    private final LoginMenu loginMenu;
    private final AccountManager accountManager;
    private final Library library;

    public MainMenu() {
        this.library = new Library();
        this.accountManager = new AccountManager();
        this.input = new Scanner(System.in);
        this.loginMenu = new LoginMenu(this.library, this.accountManager);
    }

    public void showMainMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n\n __________________\n" +
                    "|Witaj w bibliotece|\n" +
                    "|##################|\n" +
                    "|1.Logowanie       |\n" +
                    "|2.Rejestracja     |\n" +
                    "|3.Zakończ         |\n" +
                    " ------------------\n\n");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    loginMenu.showLoginMenu();
                    break;
                }
                case 2: {
                    addNewUser();
                    break;
                }
                case 3: {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("\n\nNie wybrano prawidlowej opcji!\n\n");
                    break;
                }
            }
        }
    }

    private void addNewUser() {
        System.out.print("\n\nPodaj login: ");
        input.nextLine();
        String login = this.input.nextLine();

        System.out.print("Podaj hasło: ");
        String password = this.input.nextLine();
        System.out.println("\n\n");

        if (accountManager.addUserAccount(login, password)) {
            System.out.println("\n\nPomyślnie utworzono konto\n\n");
        } else {
            System.out.println("\n\nPodany login juz istnieje!\n\n");
        }
    }


}
