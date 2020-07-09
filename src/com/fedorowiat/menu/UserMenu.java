package com.fedorowiat.menu;

import com.fedorowiat.book.Book;
import com.fedorowiat.library.Library;

import java.util.Scanner;

public class UserMenu {
    private final Library library;
    private final Scanner input;

    public UserMenu(){
        this.library = new Library();
        this.input = new Scanner(System.in);
    }

    public void showUserMenu(String login){
        System.out.print("Witaj.------");
        System.out.println("Zalogowany jako: " + login);
        System.out.println("-----------------------------");
        boolean loop = true;
        while (loop) {
            System.out.println(
                    "Biblioteka: \n" +
                            "1. Pokaż liste książek \n" +
                            "2. Wypożycz książke\n" +
                            "3. Wyloguj"
            );
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    for (Book book: library.getListOfBooks()) {
                     System.out.println("  autor = " + book.getAuthor() +
                                        "  tytuł = " + book.getTitle()  +
                                        "  rok wydania = " + book.getYearOfPublication()  +
                                        "  status = " + book.getStatus());
                    }
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
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
