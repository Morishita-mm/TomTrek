package com.tomtrek.Book;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

// TODO 日付をプリミティブ型からカスタム型に変えて、バリデーションを行うようにする
// TODO isbnをプリミティブのString型からカスタムのIsbnクラスに変えて、バリデーションを行うようにする
public class Book implements Comparable<Book> {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final int id;
    private final String title;
    private final String author;
    private final String isbn;
    private final ReadingStatus readingStatus;
    private final LocalDate publicationDate;
    private final LocalDate beginReadingDate;
    private final LocalDate finishedReadingDate;

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getIsbn() {
        return isbn;
    }

    LocalDate getPublicationDate() {
        return publicationDate;
    }

    LocalDate getBeginReadingDate() {
        return beginReadingDate;
    }

    LocalDate getFinishedReadingDate() {
        return finishedReadingDate;
    }

    ReadingStatus getReadingStatus() {
        return readingStatus;
    }

    private Book(String title, String author, String isbn, LocalDate publicationDate, LocalDate beginReadingDate,
            LocalDate finishedReadingDate, ReadingStatus readingStatus) {
        this.id = idCounter.incrementAndGet();
        this.readingStatus = readingStatus;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.beginReadingDate = beginReadingDate;
        this.finishedReadingDate = finishedReadingDate;
    }

    public static Book createBookNotBegin(String title, String author, String isbn) {
        return new Book(title, author, isbn, null, null, null, ReadingStatus.NOT_BEGIN);
    }

    public static Book createBookReading(String title, String author, String isbn, LocalDate beginReadingDate) {
        return new Book(title, author, isbn, null, beginReadingDate, null, ReadingStatus.READING);
    }

    public static Book createBookFinished(String title, String author, String isbn, LocalDate beginReadingDate,
            LocalDate finishedReadingDate) {
        return new Book(title, author, isbn, null, beginReadingDate, finishedReadingDate, ReadingStatus.FINISHED);
    }

    @Override
    public String toString() {
        return String.format(
                "Book{id=%d, title='%s', author='%s', isbn='%s', beginReadingDate=%s, finishedReadingDate=%s, readingStatus=%s}",
                id, title, author, isbn, beginReadingDate, finishedReadingDate, readingStatus);
    }

    @Override
    public int compareTo(Book book) {
        if (this.beginReadingDate == null && book.beginReadingDate == null) {
            return this.title.compareTo(book.title);
        }
        if (this.beginReadingDate == null) {
            return -1;
        }
        if (book.beginReadingDate == null) {
            return 1;
        }
        int dateComparison = this.beginReadingDate.compareTo(book.beginReadingDate);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return this.title.compareTo(book.title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Book other = (Book) obj;
        if (other.isbn.equals(this.isbn)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.isbn.hashCode();
    }

    // テストように実装 (テスト後に削除)
    public static void resetIdGenerations() {
        idCounter.set(0);
    }

}
