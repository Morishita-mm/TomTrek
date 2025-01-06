package com.tomtrek.Book;

import java.time.LocalDate;
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

    // TODO 本を追加する前に、登録されている本に同じものがないか検査し、あれば例外を投げる
    void addBook(Book book) {
        bookList.add(book);
    }

    // TODO 本を削除する前に、登録されている本に本が存在するか検査し、なければ例外を投げる
    public void removeBookById(int id) {
        Book book = searchBooksById(id);
        bookList.remove(book);
    }

    // 本を作成し、登録する(未読、読書中、読了の3パターンにオーバーロード) 
    public void createBook(String title, String author, String isbn) {
        Book book = Book.createBookNotBegin(title, author, isbn);
        addBook(book);
    }

    public void createBook(String title, String author, String isbn,
                            LocalDate beginReadingDate) {
        Book book = Book.createBookReading(title, author, isbn, beginReadingDate);
        addBook(book);
    }

    public void createBook(String title, String author, String isbn,
                            LocalDate beginReadingDate, LocalDate finishReadingDate) {
        Book book = Book.createBookFinished(title, author, isbn, beginReadingDate, finishReadingDate);
        addBook(book);
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
