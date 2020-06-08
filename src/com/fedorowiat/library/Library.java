package com.fedorowiat.library;

import com.fedorowiat.book.Book;
import com.fedorowiat.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    Scanner input = new Scanner(System.in);
    List<Book> listOfBooks = new ArrayList<Book>();

    private static int id = 0;
    private String author, title, yearOfPublication;

    public void addBookToLibrary() {
        System.out.println("Podaj tytuł książki: ");
        title = input.nextLine();

        System.out.println("Podaj autora książki: ");
        author = input.nextLine();

        System.out.println("Podaj rok publikacji książki: ");
        yearOfPublication = input.nextLine();

        listOfBooks.add(new Book(id,title,author,yearOfPublication));
        id++;

    }

}
