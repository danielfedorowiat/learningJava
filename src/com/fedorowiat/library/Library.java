package com.fedorowiat.library;

import com.fedorowiat.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final Scanner input;
    private final List<Book> listOfBooks;

    public Library() {
        this.input = new Scanner(System.in);
        this.listOfBooks = new ArrayList<>();
        this.listOfBooks.add(new Book(listOfBooks.size() + 1, "Test", "Test", "1996", "dostępna"));
        this.listOfBooks.add(new Book(listOfBooks.size() + 1, "Test2", "Test2", "1997", "dostępna"));
    }

    public void addBookToLibrary() {
        System.out.println("Podaj tytuł książki: ");
        String title = input.nextLine();

        System.out.println("Podaj autora książki: ");
        String author = input.nextLine();

        System.out.println("Podaj rok publikacji książki: ");
        String yearOfPublication = input.nextLine();

        listOfBooks.add(new Book(listOfBooks.size() + 1, title, author, yearOfPublication, "dostępna"));


    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void deleteBookFromLibrary() {
        System.out.print("Podaj id książki: ");
        int id = input.nextInt();
        System.out.println();
        if (listOfBooks.removeIf(book -> book.getId().equals(id))) {
            System.out.println("\nPomyśnie usunięto książkę.\n");

        } else {
            System.out.println("\nNie ma książki o podanym id!!\n");
        }

    }

    public void showListOfTheBooks(){
        if(listOfBooks.isEmpty()){
            System.out.println("\nNie ma żadnej ksiązki!\n");
        }else {
            for (Book book : listOfBooks) {
                System.out.println(book);
            }
        }
    }
}
