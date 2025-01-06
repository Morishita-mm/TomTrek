package com.tomtrek.Book;

import java.time.LocalDate;
import java.util.Scanner;

public class Reading implements State {
    private static final Reading instance = new Reading();
    private final Scanner scanner = new Scanner(System.in);

    private Reading() {
    }

    public static State READING() {
        return instance;
    }

    @Override
    public void updateStatus(Book book) {
        System.out.println("Enter begin reading date (yyyy-MM-dd): ");
        String beginReadingDate = scanner.nextLine();
        Book addBook = Book.createBookReading(
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                LocalDate.parse(beginReadingDate));
        BookManager.getInstance().addBook(addBook);
        BookManager.getInstance().removeBookById(book.getId());
    }
}
