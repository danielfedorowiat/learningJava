package com.fedorowiat.menu;


import com.fedorowiat.accounts.Account;
import com.fedorowiat.library.Library;

import java.util.Scanner;

public class LoginMenu {
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;
    private final Account account;
    private final Scanner input;

    public LoginMenu(Library library, final Account account) {
        this.userMenu = new UserMenu(library);
        this.account = account;
        this.adminMenu = new AdminMenu(library, this.account);
        this.input = new Scanner(System.in);
    }

    public void showLoginMenu() {
        System.out.print("\n\nPodaj login: ");
        String login = input.nextLine();

        System.out.print("Podaj hasło: ");
        String password = input.nextLine();
        System.out.println("\n\n");

        if (account.checkAccount(login, password)) {

            if (account.checkPermission(login)) {

                adminMenu.showAdminMenu(login);

            } else userMenu.showUserMenu(account.getUser(login).get());

        } else {

            System.out.println("\n\nBłędny login lub hasło\n\n");

        }


    }


}
