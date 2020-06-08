package com.fedorowiat.menu;

import com.fedorowiat.library.Library;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println(
                    "Biblioteka: \n" +
                            "1. Dodaj książkę \n" +
                            "2. Usuń książkę \n" +
                            "3. Pokaż liste książek"
            );
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    new Library().addBookToLibrary();
                    break;
                }
                default: {
                    System.out.println("Nie wybrano prawdiłowej opcji!");
                }
            }
        }
    }


}
