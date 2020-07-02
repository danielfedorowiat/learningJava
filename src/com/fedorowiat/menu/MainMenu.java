package com.fedorowiat.menu;

import com.fedorowiat.accounts.Accounts;
import com.fedorowiat.library.Library;

import java.util.Scanner;

public class MainMenu {
    private final Scanner input;
    private final LoginMenu loginMenu;
    private final Accounts accounts;
    private final Boolean m1 = true;



    public MainMenu() {
        this.accounts = new Accounts();
        this.input = new Scanner(System.in);
        this.loginMenu = new LoginMenu(this.accounts);
    }

//    public void showMenu() {
//        Library library = new Library();
//        while (true) {
//            System.out.println(
//                    "Biblioteka: \n" +
//                            "1. Dodaj książkę \n" +
//                            "2. Usuń książkę \n" +
//                            "3. Pokaż liste książek"
//            );
//            int choice = input.nextInt();
//            switch (choice) {
//                case 1: {
//                    library.addBookToLibrary();
//                    break;
//                }
//                case 3: {
//                    System.out.println(library.getListOfBooks().get(0));
//                    break;
//                }
//                default: {
//                    System.out.println("Nie wybrano prawdiłowej opcji!");
//                    break;
//                }
//            }
//        }
//
//    }

        public void showMainMenu(){
         while(m1) {
             System.out.println(" __________________\n" +
                                "|Witaj w bibliotece|\n" +
                                "|##################|\n" +
                                "|1.Logowanie       |\n" +
                                "|2.Rejestracja     |\n" +
                                " ------------------");
             int choice = input.nextInt();
             switch (choice) {
                 case 1: {
                     loginMenu.showLoginMenu();
                     break;
                 }
                 case 2: {
                     accounts.addUserAccount();
                     break;
                 }
                 default:{
                     System.out.println("Error");
                 }
             }
         }
        }


}
