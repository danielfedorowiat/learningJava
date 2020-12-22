package com.fedorowiat.menu;

import com.fedorowiat.book.Book;
import com.fedorowiat.user.User;

import java.util.Scanner;

public class UserMenu {

    private final Scanner input;

    public UserMenu(){
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
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> loop = false;
                default -> System.out.println("\n\nNie wybrano prawdiłowej opcji!\n\n");
            }
        }
    }






}
