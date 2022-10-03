package com.fedorowiat.menu;

import com.fedorowiat.user.User;

import java.util.Scanner;

public class UserMenu {

    private final Scanner input;

    public UserMenu() {
        this.input = new Scanner(System.in);
    }

    public void showUserMenu(String loggedUser) {
        boolean loop = true;
        while (loop) {
            System.out.print("\n\nWitaj.------");
            System.out.println("Zalogowany jako: " + loggedUser);
            System.out.println("-----------------------------");
            System.out.println(
                    """
                            Biblioteka:\s
                            1. Pokaż liste książek\s
                            2. Wypożycz książke
                            3. Pokaż moją listę wypożyczonych książek
                            4. Wyloguj

                            """
            );
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> loop = false;
                default -> System.out.println("\n\nNie wybrano prawdiłowej opcji!\n\n");
            }
        }
    }


}
