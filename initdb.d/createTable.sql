-- Authorテーブル
CREATE TABLE Author (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(50) NOT NULL
);

-- Publisherテーブル
CREATE TABLE Publisher (
    publisher_id INT AUTO_INCREMENT PRIMARY KEY,
    publisher_name VARCHAR(50) NOT NULL
);

-- Bookテーブル
CREATE TABLE Book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    publisher_id INT,
    title VARCHAR(50) NOT NULL,
    begin_read_date DATE,
    end_read_date DATE,
    comment TEXT,
    eval INT NOT NULL CHECK (eval BETWEEN 1 AND 5),
    CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES Publisher (publisher_id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Genreテーブル
CREATE TABLE Genre (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(50) NOT NULL
);

-- Publishテーブル
CREATE TABLE Publish (
    book_id INT,
    author_id INT,
    PRIMARY KEY (book_id, author_id),
    CONSTRAINT fk_book_author FOREIGN KEY (book_id) REFERENCES Book (book_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES Author (author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- BookGenreテーブル
CREATE TABLE BookGenre (
    genre_id INT,
    book_id INT,
    PRIMARY KEY (genre_id, book_id),
    CONSTRAINT fk_genre FOREIGN KEY (genre_id) REFERENCES Genre (genre_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_book_genre FOREIGN KEY (book_id) REFERENCES Book (book_id) ON DELETE CASCADE ON UPDATE CASCADE
);
