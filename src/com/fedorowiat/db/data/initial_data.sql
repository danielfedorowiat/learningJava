CREATE TYPE permission AS ENUM('true', 'false');

CREATE TABLE Users (
    USER_ID SERIAL NOT NULL,
    Email varchar(255) NOT NULL UNIQUE,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,
    Permission permission,
    PRIMARY KEY (User_ID)
);

CREATE TYPE status AS ENUM('dostępna', 'niedostępna');

CREATE TABLE Books (
    Book_ID SERIAL NOT NULL,
    Author varchar (255) NOT NULL,
    Title varchar (255) NOT NULL,
    YearOfPublication int NOT NULL,
    NumberOfBooksAvailable int NOT NULL,
    Status status,
    PRIMARY KEY (Book_ID)
);


CREATE TABLE Borrows (
    Borrow_ID SERIAL NOT NULL,
    User_ID int,
    Book_ID int,
    PRIMARY KEY (Borrow_ID),
    FOREIGN KEY (USER_ID) REFERENCES Users(User_ID),
    FOREIGN KEY (Book_ID) REFERENCES Books(Book_ID)
);



