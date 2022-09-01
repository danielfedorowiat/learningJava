package com.fedorowiat.menu;


import com.fedorowiat.dbservice.DataBase;
import com.fedorowiat.dbservice.DataBaseService;
import com.fedorowiat.user.User;
import com.fedorowiat.user.UserService;

import java.util.Scanner;

public class MainMenu {
    private final Scanner input;
    private final LoginMenu loginMenu;
    private UserService userService;



    public MainMenu() {
        this.input = new Scanner(System.in);
        this.loginMenu = new LoginMenu();
        this.userService = new UserService();

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
                case 1 -> System.out.println("logowanie");
                case 2 -> userService.registerAccount();
                case 3 -> loop = false;
                default -> System.out.println("\n\nNie wybrano prawidlowej opcji!\n\n");
            }
        }
    }


}
