package com.fedorowiat.menu;

import com.fedorowiat.book.Book;
import com.fedorowiat.library.Library;
import com.fedorowiat.library.LibraryService;
import com.fedorowiat.user.User;

import java.util.Scanner;

public class UserMenu {
    private final Library library;
    private final Scanner input;

    public UserMenu(Library library){
        this.library = library;
        this.input = new Scanner(System.in);
    }

    public void showUserMenu(User loggedUser){
        boolean loop = true;
        while (loop) {
            System.out.print("\n\nWitaj.------");
            System.out.println("Zalogowany jako: " + loggedUser.getLogin());
            System.out.println("-----------------------------");
            System.out.println(
                    "Biblioteka: \n" +
                            "1. Pokaż liste książek \n" +
                            "2. Wypożycz książke\n" +
                            "3. Pokaż moją listę wypożyczonych książek\n" +
                            "4. Wyloguj\n\n"
            );
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    for (Book book : library.getListOfBooks()) {
                        System.out.println("  autor = " + book.getAuthor() +
                                "  tytuł = " + book.getTitle() +
                                "  rok wydania = " + book.getYearOfPublication() +
                                "  status = " + book.getStatus());
                    }
                }
                case 2 -> library.borrowABook(loggedUser);
                case 3 -> {
//                    for (Book book : loggedUser.getBorrowedBooks()) {
//                        book.showBorrowedBooks();
//                    }
                }
                case 4 -> loop = false;
                default -> System.out.println("\n\nNie wybrano prawdiłowej opcji!\n\n");
            }
        }
    }






}
