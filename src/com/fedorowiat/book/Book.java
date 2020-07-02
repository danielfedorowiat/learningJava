package com.fedorowiat.book;

public class Book {
    private final Integer id;
    private final String author;
    private final String title;
    private final String yearOfPublication;

    public Book(Integer id, String title, String author, String yearOfPublication){
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                '}';
    }
}
