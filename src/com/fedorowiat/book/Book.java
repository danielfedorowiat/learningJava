package com.fedorowiat.book;


public class Book {
    private final Integer id;
    private final String author;
    private final String title;
    private final String yearOfPublication;
    private Integer numberOfBooksAvailable;
    private String status;
    public static int licznik=0;

    public Book(Integer id, String title, String author, String yearOfPublication, Integer numberOfBooksAvailable, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.numberOfBooksAvailable = numberOfBooksAvailable;
        this.status = status;
        licznik++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                ", numberOfBooksAvailable=" + numberOfBooksAvailable +
                ", status='" + status + '\'' +
                '}';
    }


    public void showBorrowedBooks() {
        System.out.println("author: " + author + '\'' +
                "    title: " + title + '\'' + "\n\n");
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

    public Integer getNumberOfBooksAvailable() {
        return numberOfBooksAvailable;
    }

    public Integer getId() {
        return id;
    }


    public void setNumberOfBooksAvailable(int numberOfBooksAvailable) {
        this.numberOfBooksAvailable = numberOfBooksAvailable;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public  static void  setLicznik(int licznik){
        System.out.println(Book.licznik=licznik);
    }

    public static Book creatNewBook(){
       return new Book(4,"dupa","dupa","123",123,"dostępna");
    }


}
