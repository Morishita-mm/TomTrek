package com.tomtrek.Book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    private BookManager bookManager;

    private final InputStream originalIn = System.in; // 元のSystem.inを保存

    @BeforeEach
    void setUp() {
        Book.resetIdGenerations();
        bookManager = BookManager.getInstance();
        bookManager.addBook(Book.createBookNotBegin("Effective Java", "Joshua Bloch", "9780134685991"));
        bookManager.addBook(Book.createBookNotBegin("Clean Code", "Robert C. Martin", "9780132350884"));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn); // テスト後にSystem.inを元に戻す
    }
    
    @Test
    public void testAddBook() {
        Book book = Book.createBookNotBegin("Refactoring", "Martin Fowler", "9780201485677");
        bookManager.addBook(book);
        assertEquals(bookManager.searchBooksById(3), book);
    }

    @Test
    public void testRemoveBookById() {
        bookManager.removeBookById(1);
        assertNull(bookManager.searchBooksById(1));
    }

    @Test
    public void testSearchBooksByTitle() {
        List<Book> books = bookManager.searchBooksByTitle("Effective Java");
        assertEquals(1, books.size());
        assertEquals("Effective Java", books.get(0).getTitle());
    }

    @Test
    public void testSearchBooksById() {
        Book book = bookManager.searchBooksById(2);
        assertNotNull(book);
        assertEquals("Clean Code", book.getTitle());
    }
    @Test
    void testUpdateStatus_Reading() {
        // 標準入力をモック化
        String input = "2024-01-01\n"; // beginReadingDate の入力
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // テスト実行
        Book book = bookManager.searchBooksById(1);
        bookManager.updateStatus(book, Reading.READING());

        // 結果の検証
        Book updatedBook = bookManager.searchBooksByTitle("Effective Java").get(0);
        assertEquals(ReadingStatus.READING, updatedBook.getReadingStatus());
        assertEquals(LocalDate.parse("2024-01-01"), updatedBook.getBeginReadingDate());
    }

    @Test
    void testUpdateStatus_Finished() {
        bookManager.addBook(Book.createBookReading("Readable code", "Dustin Boswell", "9780596517748", LocalDate.parse("2024-01-01")));
        // 標準入力をモック化
        String input = "2024-01-10\n"; // beginReadingDate と finishedReadingDate の入力
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // テスト実行
        Book book = bookManager.searchBooksByTitle("Readable code").get(0);
        bookManager.updateStatus(book, Finished.FINISHED());

        // 結果の検証
        Book updatedBook = bookManager.searchBooksByTitle("Readable code").get(0);
        assertEquals(ReadingStatus.FINISHED, updatedBook.getReadingStatus());
        assertEquals(LocalDate.parse("2024-01-01"), updatedBook.getBeginReadingDate());
        assertEquals(LocalDate.parse("2024-01-10"), updatedBook.getFinishedReadingDate());
    }
}