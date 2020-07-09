package com.fedorowiat.book;

public class Book {
    private final Integer id;
    private final String author;
    private final String title;
    private final String yearOfPublication;
    private final String status;

    public Book(Integer id, String title, String author, String yearOfPublication, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public String getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }


}
