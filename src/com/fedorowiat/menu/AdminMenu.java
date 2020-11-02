package com.fedorowiat.menu;


import com.fedorowiat.accounts.Account;
import com.fedorowiat.library.Library;
import java.util.Scanner;

public class AdminMenu {
    private final Scanner input;
    private final Library library;
    private final Account account;

    public AdminMenu(Library library, Account account) {
        this.library = library;
        this.input = new Scanner(System.in);
        this.account = account;
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
                            "6. Wyloguj\n\n"
            );
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> library.addBookToLibrary();
                case 2 -> library.deleteBookFromLibrary();
                case 3 -> library.showListOfTheBooks();
                case 4 -> account.showUsers();
                case 5 -> account.showBorrowedBooksByTheUsers();
                case 6 -> loop = false;
                default -> System.out.println("\n\nNie wybrano prawdiłowej opcji!\n\n");
            }
        }

    }
}

