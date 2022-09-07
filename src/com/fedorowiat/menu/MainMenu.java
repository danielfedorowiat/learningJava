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
            System.out.println("""
                     

                     __________________
                    |Witaj w bibliotece|
                    |##################|
                    |1.Logowanie       |
                    |2.Rejestracja     |
                    |3.Zakończ         |
                     ------------------

                    """);
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
