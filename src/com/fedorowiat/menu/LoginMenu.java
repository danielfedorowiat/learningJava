package com.fedorowiat.menu;



import com.fedorowiat.dbservice.DataBase;

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
            if(dataBase.checkLoginData(login, password)){
                if (dataBase.getAccessLevel(login, password).equals("false")){
                    userMenu.showUserMenu(login);
                } else if (dataBase.getAccessLevel(login, password).equals("true")) {
                    adminMenu.showAdminMenu(login);
                } else {
                    System.out.println("Błędny login lub hasło");
                }
            }

    }


}
