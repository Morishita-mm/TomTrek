package com.tomtrek.Book;

class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final Isbn isbn;
    private final ReadingDate beginReadingDate;
    private final ReadingDate finishReadingDate;
    private final BookStatus status;
    
    private Book(String title, String author, Isbn isbn, ReadingDate beginReadingDate, ReadingDate finishReadingDate, BookStatus status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.beginReadingDate = beginReadingDate;
        this.finishReadingDate = finishReadingDate;
        this.status = status;
    }

    public static class Builder {
        private final String title;
        private final String author;
        private final Isbn isbn;
        private ReadingDate beginReadingDate = ReadingDate.NO_DATA;
        private ReadingDate finishReadingDate = ReadingDate.NO_DATA;
        private BookStatus status = NotBegin.create();

        Builder(String title, String author, Isbn isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        Builder setBeginReadingDate(ReadingDate date) {
            this.beginReadingDate = date;
            return this;
        }

        Builder setFinishReadingDate(ReadingDate date) {
            this.finishReadingDate = date;
            return this;
        }

        Builder setStatus(BookStatus status) {
            this.status = status;
            return this;
        }

        Book build() {
            return new Book(title, author, isbn, beginReadingDate, finishReadingDate, status);
        }
    }

    @Override
    public String toString() {
        return String.format("title: %s, author: %s, isbn: %s, beginDate: %s, finishDate: %s, status: %s",
                                            title, author, isbn, beginReadingDate, finishReadingDate, status);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Book book1 = (Book) other;
        return isbn.equals(book1.isbn);
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
