package com.fedorowiat.book;

public class Book {
    private int id;
    private String author, title, yearOfPublication;

    public Book(int id, String title, String author, String yearOfPublication){
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
}
