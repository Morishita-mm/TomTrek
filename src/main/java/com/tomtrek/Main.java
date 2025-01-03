package com.tomtrek;

import java.io.IOException;
import java.time.LocalDate;

import com.tomtrek.Book.*;
import static com.tomtrek.Book.Reading.*;
import static com.tomtrek.Book.Finished.*;
import static com.tomtrek.Book.NotBegin.*;

// TODO 全体的に引数にfinalをつけて、メソッドの内部で変更が加えられていないことを明記する
public class Main {
    public static void main(String[] args) throws IOException {
        BookManager bookManager = BookManager.getInstance();
        Book book = Book.createBookNotBegin("Effective Java", "Joshua Bloch", "123456789");
        bookManager.addBook(book);

        LocalDate date = LocalDate.of(2021, 1, 1);

        Book book2 = Book.createBookReading("Readable Code", "Joshua Bloch", "012345678", date);
        bookManager.addBook(book2);
        
        bookManager.getBookList().stream().toList().forEach(System.out::println);
        // bookManager.updateStatus(bookManager.searchBooksByTitle("Effective Java").getFirst(), NOT_BEGIN());
        // System.out.println(bookManager.searchBooksByTitle("Effective Java"));

        // bookManager.updateStatus(bookManager.searchBooksByTitle("Effective Java").getFirst(), READING());
        // System.out.println(bookManager.searchBooksByTitle("Effective Java"));

        System.out.println();
        bookManager.updateStatus(bookManager.searchBooksByTitle("Readable Code").getFirst(), FINISHED());
        System.out.println(bookManager.searchBooksByTitle("Readable Code"));

        
    }
}