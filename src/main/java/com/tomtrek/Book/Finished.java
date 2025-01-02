package com.tomtrek.Book;

import java.time.LocalDate;
import java.util.Scanner;

public class Finished implements State {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Finished instance = new Finished();

    private Finished() {
    }

    public static State getInstance() {
        return instance;
    }

    @Override
    public void updateStatus(Book book) {
        if (book.getBeginReadingDate() == null) {
            System.out.println("読み始めた日付が設定されていません");
            return;
        }

        System.out.println("Enter finish reading date (yyyy-MM-dd): ");
        String finishReadingDate = scanner.nextLine();
        Book addBook = Book.createBookFinished(
            book.getTitle(),
            book.getAuthor(),
            book.getIsbn(),
            book.getBeginReadingDate(),
            LocalDate.parse(finishReadingDate));
        BookManager.getInstance().addBook(addBook);
        BookManager.getInstance().removeBookById(book.getId());
    }
}
