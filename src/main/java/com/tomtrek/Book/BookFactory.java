package com.tomtrek.Book;

public class BookFactory {
    /*
     * throw IllegalArgumentException isbn形式、日付の形式、未来の日付が渡された時にスローされる
     */
    public static Book createNewBook(String title, String author, String isbn) {
        return new Book.Builder(title, author, Isbn.create(isbn))
                .build();
    }

    /*
     * throw IllegalArgumentException isbn形式、日付の形式、未来の日付が渡された時にスローされる
     */
    public static Book createReadingBook(String title, String author, String isbn, ReadingDate beginDate) {
        return new Book.Builder(title, author, Isbn.create(isbn))
                .setBeginReadingDate(beginDate)
                .setStatus(Reading.create())
                .build();
    }

    /*
     * throw IllegalArgumentException isbn形式、日付の形式、未来の日付が渡された時にスローされる
     */
    public static Book createFinishedBook(String title, String author, String isbn, ReadingDate beginDate,
            ReadingDate finishDate) {
        return new Book.Builder(title, author, Isbn.create(isbn))
                .setBeginReadingDate(beginDate)
                .setFinishReadingDate(finishDate)
                .setStatus(Finish.create())
                .build();
    }
}