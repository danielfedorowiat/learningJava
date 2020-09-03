package com.fedorowiat.library;

import com.fedorowiat.book.Book;
import com.fedorowiat.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final Scanner input;
    private final List<Book> listOfBooks;

    public Library() {
        this.input = new Scanner(System.in);
        this.listOfBooks = new ArrayList<>();
        this.listOfBooks.add(new Book(listOfBooks.size() + 1, "Test", "Test", "1996", 1, "dostępna"));
        this.listOfBooks.add(new Book(listOfBooks.size() + 1, "Test2", "Test2", "1997", 1, "dostępna"));
    }

    public void addBookToLibrary() {
        System.out.println("\n\nPodaj tytuł książki: ");
        String title = input.nextLine();
        input.nextLine();
        System.out.println("Podaj autora książki: ");
        String author = input.nextLine();

        System.out.println("Podaj rok publikacji książki: ");
        String yearOfPublication = input.nextLine();

        System.out.println("Podaj ilość książek: ");
        Integer numberOfBooksAvailable = input.nextInt();
        System.out.println("\n\n");
        listOfBooks.add(new Book(listOfBooks.size() + 1, title, author, yearOfPublication, numberOfBooksAvailable, "dostępna"));


    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void deleteBookFromLibrary() {
        System.out.print("\n\nPodaj id książki: ");
        int id = input.nextInt();
        System.out.println();
        if (listOfBooks.removeIf(book -> book.getId().equals(id))) {
            System.out.println("\n\nPomyśnie usunięto książkę.\n\n");

        } else {
            System.out.println("\n\nNie ma książki o podanym id!!\n\n");
        }

    }

    public void showListOfTheBooks() {
        if (listOfBooks.isEmpty()) {
            System.out.println("\n\nNie ma żadnej ksiązki!\n\n");
        } else {
            for (Book book : listOfBooks) {
                System.out.println(book);
            }
        }
    }

    public void borrowABook(User loggedUser) {
        System.out.println("\n\nPodaj tytuł książki: ");
        String searchTitleByUser = input.nextLine();
        for (Book book : listOfBooks) {
            if (checkTitle(book.getTitle(), searchTitleByUser)) {
                borrowWhenPossible(book, loggedUser);
                return;
            }
        }
        System.out.println("\n\nNie ma takiej książki o podanym tytule!\n\n");
    }

    private void borrowWhenPossible(Book book, User loggedUser) {
        if (book.getNumberOfBooksAvailable() > 0) {
            lowerBookQuantityAndUpdateStatus(book, loggedUser);
        } else {
            System.out.println("\n\nNie ma więcej książek na stanie!\n\n");
        }
    }

    private boolean checkTitle(String bookTitle, String searchedTitle) {
        return bookTitle.toLowerCase().equals(searchedTitle.toLowerCase());
    }

    private void lowerBookQuantityAndUpdateStatus(Book book, User loggedUser) {
        book.setNumberOfBooksAvailable(book.getNumberOfBooksAvailable() - 1);
        loggedUser.getBorrowedBooks().add(book);
        System.out.println("\n\nPomysnie wypozyczono książkę.\n\n");
        if (book.getNumberOfBooksAvailable() == 0)
            book.setStatus("\n\nNiedostepna\n\n");
    }


}
