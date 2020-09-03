package com.fedorowiat.menu;

import com.fedorowiat.Main;
import com.fedorowiat.accounts.AccountManager;
import com.fedorowiat.library.Library;

import java.util.Scanner;

public class LoginMenu {
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;
    private final AccountManager accountManager;
    private final Scanner input;

    public LoginMenu(Library library, final AccountManager accountManager) {
        this.userMenu = new UserMenu(library);
        this.accountManager = accountManager;
        this.adminMenu = new AdminMenu(library, this.accountManager);
        this.input = new Scanner(System.in);
    }

    public void showLoginMenu() {
        System.out.print("\n\nPodaj login: ");
        String login = input.nextLine();

        System.out.print("Podaj hasło: ");
        String password = input.nextLine();
        System.out.println("\n\n");
        if (accountManager.checkAccount(login, password)) {
            if (accountManager.checkPermission(login)) {
                adminMenu.showAdminMenu(login);
            } else userMenu.showUserMenu(accountManager.getUser(login).get());
        } else {
            System.out.println("\n\nBłędny login lub hasło\n\n");
        }


    }


}
