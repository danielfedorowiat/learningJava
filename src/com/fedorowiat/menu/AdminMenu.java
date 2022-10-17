package com.fedorowiat.menu;

import java.util.Scanner;

public class AdminMenu {
    private final Scanner input;

    public AdminMenu() {
        this.input = new Scanner(System.in);
    }

    public void showAdminMenu(String login) {
        boolean loop = true;
        while (loop) {
            System.out.println("\nWitaj.------");
            System.out.println("Zalogowany jako: " + login);
            System.out.println("-----------------------------");
            System.out.println(
                """
                    Biblioteka:
                    1. Dodaj książkę
                    2. Usuń książkę
                    3. Pokaż liste książek
                    4. Pokaż listę użytkowników
                    5. Pokaż listę osób, które wypożyczyły książkę
                    6. Wyloguj
                """
            );
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> loop = false;
                default -> System.out.println("\n\nNie wybrano prawdiłowej opcji!\n\n");
            }
        }
    }

}

