package com.tomtrek.Book;

import java.util.ArrayList;
import java.util.List;

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

    public void updateStatus(Book book, State state) {
        state.updateStatus(book);
    }

    public int getBookListSize() {
        return bookList.size();
    }

    public List<Book> getBookList() {
        return bookList;
    }

}
