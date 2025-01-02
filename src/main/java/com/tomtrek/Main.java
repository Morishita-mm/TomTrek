package com.tomtrek;

import java.io.IOException;

import com.tomtrek.Book.Book;
import com.tomtrek.Book.BookManager;

public class Main {
    public static void main(String[] args) throws IOException {
        BookManager bookManager = BookManager.getInstance();
        Book book = Book.createBookNotBegin("Effective Java", "Joshua Bloch", "123456789");
        bookManager.addBook(book);
        Book targetBook = bookManager.searchBooksById(1);
        System.out.println(targetBook);
    }
}