
CREATE TABLE Users (
    user_id SERIAL NOT NULL,
    email varchar(255) NOT NULL UNIQUE,
    last_name varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    access_level varchar(255) NOT NULL,
    PRIMARY KEY (user_id)
);


CREATE TABLE Books (
    book_id SERIAL NOT NULL,
    author varchar (255) NOT NULL,
    title varchar (255) NOT NULL,
    year_of_publication int NOT NULL,
    number_of_books_available int NOT NULL,
    status varchar(255) NOT NULL,
    PRIMARY KEY (book_id)
);


CREATE TABLE Borrows (
    borrow_id SERIAL NOT NULL,
    user_id int,
    book_id int,
    PRIMARY KEY (borrow_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);



