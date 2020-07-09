package com.fedorowiat.menu;


import com.fedorowiat.book.Book;
import com.fedorowiat.library.Library;

import java.util.Collections;
import java.util.Scanner;

public class AdminMenu {
    private final Scanner input;
    private final Library library;

    public AdminMenu() {
        this.library = new Library();
        this.input = new Scanner(System.in);
    }


    public void showAdminMenu(String login) {
        System.out.print("Witaj.------");
        System.out.println("Zalogowany jako: " + login);
        System.out.println("-----------------------------");
        boolean loop = true;
        while (loop) {
            System.out.println(
                    "Biblioteka: \n" +
                            "1. Dodaj książkę \n" +
                            "2. Usuń książkę \n" +
                            "3. Pokaż liste książek\n" +
                            "4. Wyloguj"
            );
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    library.addBookToLibrary();
                    break;
                }
                case 2: {
                    library.deleteBookFromLibrary();
                    break;
                }
                case 3: {
                    library.showListOfTheBooks();
                    break;
                }
                case 4: {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("Nie wybrano prawdiłowej opcji!");
                    break;
                }
            }
        }

    }
}

