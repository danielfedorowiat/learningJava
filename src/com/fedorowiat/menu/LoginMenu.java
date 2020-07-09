package com.fedorowiat.menu;

import com.fedorowiat.accounts.Accounts;

import java.util.Scanner;

public class LoginMenu {
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;
    private final Accounts accounts;
    private final Scanner input;

    public LoginMenu(final Accounts accounts) {
        this.userMenu = new UserMenu();
        this.accounts = accounts;
        this.adminMenu = new AdminMenu();
        this.input = new Scanner(System.in);
    }

    public void showLoginMenu() {
        System.out.print("Podaj login: ");
        String login = input.nextLine();

        System.out.print("Podaj hasło: ");
        String password = input.nextLine();

        if (accounts.checkAccount(login,password)) {
            if (accounts.checkPermission(login)) {
                adminMenu.showAdminMenu(login);
            } else {
                userMenu.showUserMenu(login);
            }
        } else {
            System.out.println("\nBłędny login lub hasło\n");
        }


    }


}
