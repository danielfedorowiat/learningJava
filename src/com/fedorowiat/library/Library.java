package com.fedorowiat.library;

import com.fedorowiat.book.Book;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final Scanner input;
    private final List<Book> listOfBooks;

    public Library(Scanner input, List<Book> listOfBooks) {
        this.input = input;
        this.listOfBooks = listOfBooks;
    }

    public void addBookToLibrary() {
        System.out.println("Podaj tytuł książki: ");
        String title = input.nextLine();

        System.out.println("Podaj autora książki: ");
        String author = input.nextLine();

        System.out.println("Podaj rok publikacji książki: ");
        String yearOfPublication = input.nextLine();

        listOfBooks.add(new Book(listOfBooks.size()+1,title,author,yearOfPublication));


    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }
}
