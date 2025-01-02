package com.tomtrek.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private static final BookManager instance = new BookManager();
    private List<Book> bookList;

    private BookManager() {
        bookList = new ArrayList<>();
    }

    public static BookManager getInstance() {
        return instance; 
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBookById(int id) {
        Book book = searchBooksById(id);
        bookList.remove(book);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookList.stream().filter(book -> book.getTitle().contains(title)).toList();
    }

    public Book searchBooksById(int id) {
        return bookList.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    // TODO statusにStateパターンを適用する
    // TODO state IFを作って、それを実装したnotBegin, reading, finishedを作る
    public void updateStatus(Book book, ReadingStatus status) {
        bookList.remove(book);
        Book addBook;
        try (Scanner scanner = new Scanner(System.in)) {
            switch (status) {
                case NOT_BEGIN:
                    addBook = Book.createBookNotBegin(book.getTitle(), book.getAuthor(), book.getIsbn());
                    break;
                case READING:
                    System.out.print("Enter begin reading date (yyyy-MM-dd): ");
                    String beginReadingDate = scanner.nextLine();
                    addBook = Book.createBookReading(book.getTitle(), book.getAuthor(), book.getIsbn(),
                            LocalDate.parse(beginReadingDate));
                    break;
                case FINISHED:
                    System.out.print("Enter begin reading date (yyyy-MM-dd): ");
                    beginReadingDate = scanner.nextLine();
                    System.out.print("Enter finished reading date (yyyy-MM-dd): ");
                    String finishedReadingDate = scanner.nextLine();
                    addBook = Book.createBookFinished(book.getTitle(), book.getAuthor(), book.getIsbn(),
                            LocalDate.parse(beginReadingDate), LocalDate.parse(finishedReadingDate));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid status");
            }
        }

        bookList.add(addBook);
    }
}
