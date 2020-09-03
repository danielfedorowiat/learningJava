package com.fedorowiat.menu;


import com.fedorowiat.accounts.AccountManager;

import com.fedorowiat.book.Book;
import com.fedorowiat.library.Library;


import java.util.Scanner;

public class AdminMenu {
    private final Scanner input;
    private final Library library;
    private final AccountManager accountManager;

    public AdminMenu(Library library,AccountManager accountManager) {
        this.library = library;
        this.input = new Scanner(System.in);
        this.accountManager = accountManager;
    }


    public void showAdminMenu(String login) {
        boolean loop = true;
        while (loop) {
            System.out.print("\n\nWitaj.------");
            System.out.println("Zalogowany jako: " + login);
            System.out.println("-----------------------------");
            System.out.println(
                    "Biblioteka: \n" +
                            "1. Dodaj książkę \n" +
                            "2. Usuń książkę \n" +
                            "3. Pokaż liste książek\n" +
                            "4. Pokaż listę użytkowników\n" +
                            "5. Pokaż listę osób, które wypożyczyły książkę\n" +
                            "6. Pokaż ilość książek\n" +
                            "7. Wyloguj\n" +
                            "8. Ustawi licznk na 0\n\n"

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
                    accountManager.showUsers();
                    break;
                }
                case 5: {
                    accountManager.showBorrowedBooksByTheUsers();
                    break;
                }
                case 6: {
                    System.out.println(Book.licznik);
                    break;
                }
                case 7: {
                    loop = false;
                    break;
                }
                case 8: {
                    Book.setLicznik(0);
                    break;
                }
                default: {
                    System.out.println("\n\nNie wybrano prawdiłowej opcji!\n\n");
                    break;
                }
            }
        }

    }
}

