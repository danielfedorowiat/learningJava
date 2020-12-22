package com.fedorowiat.menu;



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

    public void showLoginMenu() {
        System.out.print("\n\nPodaj login: ");
        String login = input.nextLine();

        System.out.print("Podaj hasło: ");
        String password = input.nextLine();
        System.out.println("\n\n");
    }


}
