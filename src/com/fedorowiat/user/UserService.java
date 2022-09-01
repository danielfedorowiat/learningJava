package com.fedorowiat.user;

import com.fedorowiat.dbservice.DataBase;
import com.fedorowiat.dbservice.DataBaseService;

import java.util.Scanner;

public class UserService {
    private User user;
    private Scanner scanner;
    private DataBase dataBase;

    public UserService() {
        this.scanner = new Scanner(System.in);
        this.user = new User("", "", "", "", false);
        this.dataBase = new DataBaseService();
    }


    public void registerAccount() {
        var reenterLogin = true;
        while (reenterLogin) {
            System.out.println("Podaj login: ");
            var login = scanner.nextLine();
            if (checkEmailIsExist(login)) {
                System.out.println("Podaj imię: ");
                user.setFirstName(scanner.nextLine());

                System.out.println("Podaj nazwisko: ");
                user.setLastName(scanner.nextLine());

                checkIfPasswordAreEquals();
                dataBase.setUser(user);
                System.out.println("Pomyślnie utworzono konto.");
                reenterLogin = false;
            } else {
                System.out.println("Podany email juz istnieje!");
            }
        }
    }

    private boolean checkEmailIsExist(String email) {
        return dataBase.getEmail(email).length() == 0;
    }

    private void checkIfPasswordAreEquals() {
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
