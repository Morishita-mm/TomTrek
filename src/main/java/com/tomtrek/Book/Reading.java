package com.tomtrek.Book;

import java.time.LocalDate;
import java.util.Scanner;

public class Reading implements State {
    private static final Reading instance = new Reading();

    private Reading() {
    }

    public static State getInstance() {
        return instance;
    }

    @Override
        public void updateStatus(Book book) {
            System.out.println("Enter begin reading date (yyyy-MM-dd): ");
            try (Scanner scanner = new Scanner(System.in)) {
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

}
