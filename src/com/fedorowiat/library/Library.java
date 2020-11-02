package com.fedorowiat.library;

import com.fedorowiat.book.Book;
import com.fedorowiat.user.User;

import java.util.List;

public interface Library {
    void addBookToLibrary();
    List<Book> getListOfBooks();
    void deleteBookFromLibrary();
    void showListOfTheBooks();
    void borrowABook(User loggedUser);
}
