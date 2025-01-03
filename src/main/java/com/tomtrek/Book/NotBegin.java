package com.tomtrek.Book;

public class NotBegin implements State {

    private static final NotBegin instance = new NotBegin();

    private NotBegin() {
    }

    public static State NOT_BEGIN() {
        return instance;
    }

    @Override
    public void updateStatus(Book book) {
        System.out.println("この本の状態を\"未読\"に設定します");
        Book addBook = Book.createBookNotBegin(
                book.getTitle(),
                book.getAuthor(),
                book.getTitle());
        BookManager.getInstance().addBook(addBook);
        BookManager.getInstance().removeBookById(book.getId());
    }

}
