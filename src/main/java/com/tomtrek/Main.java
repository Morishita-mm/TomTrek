package com.tomtrek;

import java.io.IOException;
import java.time.LocalDate;

import com.tomtrek.Book.Book;
import com.tomtrek.Book.BookManager;
import com.tomtrek.Book.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BookManager bookManager = BookManager.getInstance();
        Book book = Book.createBookNotBegin("Effective Java", "Joshua Bloch", "123456789");
        bookManager.addBook(book);

        LocalDate date = LocalDate.of(2021, 1, 1);

        Book book2 = Book.createBookReading("Readable Code", "Joshua Bloch", "123456789", date);
        bookManager.addBook(book2);
        
        bookManager.updateStatus(bookManager.searchBooksByTitle("Effective Java").getFirst(), NotBegin.getInstance());
        System.out.println(bookManager.searchBooksByTitle("Effective Java"));

        bookManager.updateStatus(bookManager.searchBooksByTitle("Effective Java").getFirst(), Reading.getInstance());
        System.out.println(bookManager.searchBooksByTitle("Effective Java"));

        bookManager.updateStatus(bookManager.searchBooksByTitle("Readable Code").getFirst(), Finished.getInstance());
        System.out.println(bookManager.searchBooksByTitle("Readable Code"));

        
    }
}