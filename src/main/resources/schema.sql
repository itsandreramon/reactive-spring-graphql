CREATE TABLE authors
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE books
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    authorId INTEGER NOT NULL REFERENCES authors(id)
);

CREATE TABLE customers
(
    id  SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE orders
(
    id SERIAL PRIMARY KEY,
    customerId INTEGER NOT NULL REFERENCES customers(id),
    bookId INTEGER NOT NULL REFERENCES books(id)
);

INSERT INTO authors(name) VALUES
    ('Leo Tolstoy'),
    ('Harper Lee'),
    ('F. Scott Fitzgerald'),
    ('Gabriel Garcia Marquez'),
    ('E.M. Forster'),
    ('Ralph Ellison'),
    ('Miguel de Cervantes'),
    ('Toni Morrison'),
    ('Virginia Woolf'),
    ('Chinua Achebe'),
    ('Charlotte Brontë'),
    ('Alice Walker');

INSERT INTO books(name, authorid) VALUES
    ('Anna Karenina', 1),
    ('To Kill a Mockingbird', 2),
    ('The Great Gatsby', 3),
    ('One Hundred Years of Solitude', 4),
    ('A Passage to India', 5),
    ('Invisible Man', 6),
    ('Don Quixote', 7),
    ('Beloved', 8),
    ('Mrs. Dalloway', 9),
    ('Things Fall Apart', 10),
    ('Jane Eyre', 11),
    ('The Color Purple', 12);

INSERT INTO customers(name) VALUES
    ('James Parker');

INSERT INTO orders(customerId, bookId) VALUES
    (1, 2);

SELECT * FROM books;
SELECT * FROM authors;
SELECT * FROM customers;
SELECT * FROM orders;

DROP TABLE authors CASCADE;
DROP TABLE books CASCADE;
DROP TABLE customers CASCADE;
DROP TABLE orders CASCADE;