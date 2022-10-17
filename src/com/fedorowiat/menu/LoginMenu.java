package com.fedorowiat.menu;


import com.fedorowiat.dbservice.DataBase;
import com.fedorowiat.exception.UserNotFoundException;
import com.fedorowiat.user.UserType;

import java.util.Scanner;

public class LoginMenu {
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;
    private final Scanner input;

    public LoginMenu() {
        this.userMenu = new UserMenu();
        this.adminMenu = new AdminMenu();
        this.input = new Scanner(System.in);
    }

    public void showLoginMenu(DataBase dataBase) {
        System.out.print("\n\nPodaj login: ");
        var login = input.nextLine();
        System.out.print("Podaj hasło: ");
        var password = input.nextLine();
        System.out.println("\n\n");
        String accessLevel = null;
        try {
            accessLevel = dataBase.getAccessLevel(login, password);
        } catch (UserNotFoundException e) {
            System.out.println("Błędny login lub hasło");
        }

        if (UserType.ADMIN.name().equals(accessLevel)) {
            adminMenu.showAdminMenu(login);
        }
        userMenu.showUserMenu(login);
    }


}
