package com.tomtrek.Book;

import java.util.Random;

public class Isbn {
    private final String isbn;

    private Isbn(String isbn) {
        if (!isValidIsbn(isbn)) {
            throw new IllegalArgumentException("無効なISBN形式です");
        }
        this.isbn = isbn;
    }

    private boolean isValidIsbn(String isbn) {
        return isbn != null && isbn.matches("\\d{3}-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1}");
    }

    public static Isbn create(String str) {
        return new Isbn(str);
    }

    // 動作確認用のメソッド
    public static Isbn randomCreate() {
        Random random = new Random();
        String isbn = String.format("%03d-%05d-%07d-%07d-%01d",
                                    random.nextInt(1000),
                                    random.nextInt(100000),
                                    random.nextInt(10000000),
                                    random.nextInt(10000000),
                                    random.nextInt(10));
        return new Isbn(isbn);
    }

    @Override
    public String toString() {
        return isbn;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Isbn isbn1 = (Isbn) other;
        return isbn.equals(isbn1.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
