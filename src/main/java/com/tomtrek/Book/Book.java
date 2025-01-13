package com.tomtrek.Book;

public class Book {
    private final String title;
    private final String author;
    private final Isbn isbn;
    private final ReadingDate beginReadingDate;
    private final ReadingDate finishReadingDate;
    
    public Book(String title, String author, Isbn isbn, ReadingDate beginReadingDate, ReadingDate finishReadingDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.beginReadingDate = beginReadingDate;
        this.finishReadingDate = finishReadingDate;
    }

    @Override
    public String toString() {
        return String.format("title: %s, author: %s, isbn: %s, beginDate: %s, finishDate: %s",
                                            title, author, isbn, beginReadingDate, finishReadingDate);
    }
}
