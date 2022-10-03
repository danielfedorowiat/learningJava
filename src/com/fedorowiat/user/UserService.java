package com.fedorowiat.user;

import com.fedorowiat.dbservice.DataBase;
import com.fedorowiat.dbservice.DataBaseService;

import java.util.Scanner;

public class UserService {
    private Scanner scanner;
    private DataBase dataBase;

    public UserService() {
        this.scanner = new Scanner(System.in);
        this.dataBase = new DataBaseService();
    }


    public void registerAccount() {
        User user = new User("", "", "", "", false);
        var reenterLogin = true;
        while (reenterLogin) {
            System.out.println("Podaj email: ");
            var login = scanner.nextLine();
            if (dataBase.checkEmailIsExist(login)) {
                System.out.println("Podaj imię: ");
                user.setFirstName(scanner.nextLine());

                System.out.println("Podaj nazwisko: ");
                user.setLastName(scanner.nextLine());

                checkIfPasswordAreEquals(user);
                dataBase.saveUser(user);
                System.out.println("Pomyślnie utworzono konto.");
                reenterLogin = false;
            } else {
                System.out.println("Podany email juz istnieje!");
            }
        }
    }


    private void checkIfPasswordAreEquals(User user) {
        var isNotCorrect = true;
        while (isNotCorrect) {
            System.out.println("Podaj hasło: ");
            var password_1 = scanner.nextLine();
            System.out.println("Podaj ponownie hasło");
            var password_2 = scanner.nextLine();
            if (password_1.equals(password_2)) {
                user.setPassword(password_1);
                isNotCorrect = false;
            }

        }
    }


}
