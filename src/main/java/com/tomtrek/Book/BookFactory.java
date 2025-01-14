package com.tomtrek.Book;

public class BookFactory {
    public static Book createNewBook(String title, String author, String isbn) {
        return new Book.Builder(title, author, Isbn.create(isbn))
                .build();
    }

    public static Book createReadingBook(String title, String author, String isbn, ReadingDate beginDate) {
        return new Book.Builder(title, author, Isbn.create(isbn))
                .setBeginReadingDate(beginDate)
                .setStatus(Reading.create())
                .build();
    }

    public static Book createFinishedBook(String title, String author, String isbn, ReadingDate beginDate, ReadingDate finishDate) {
        return new Book.Builder(title, author, Isbn.create(isbn))
                .setBeginReadingDate(beginDate)
                .setFinishReadingDate(finishDate)
                .setStatus(Finish.create())
                .build();
    }
}