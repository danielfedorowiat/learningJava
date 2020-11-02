package com.fedorowiat.menu;


import com.fedorowiat.accounts.Account;
import com.fedorowiat.accounts.AccountService;
import com.fedorowiat.library.Library;
import com.fedorowiat.library.LibraryService;

import java.util.Scanner;

public class MainMenu {
    private final Scanner input;
    private final LoginMenu loginMenu;
    private final Account account;

    public MainMenu() {
        Library library = LibraryService.libraryService();
        this.account = AccountService.accountService();
        this.input = new Scanner(System.in);
        this.loginMenu = new LoginMenu(library, account);
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
                case 1 -> loginMenu.showLoginMenu();
                case 2 -> account.addNewUser();
                case 3 -> loop = false;
                default -> System.out.println("\n\nNie wybrano prawidlowej opcji!\n\n");
            }
        }
    }


}
