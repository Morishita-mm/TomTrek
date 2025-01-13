package com.tomtrek.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    @DisplayName("BookModelのtoStringメソッドテスト")
    public void testBookInfo() {
        Book book = new Book("title", "author", Isbn.create("978-4-295-00762-3"), ReadingDate.create("2025-01-01"), ReadingDate.create("2025-01-01"));
        assertEquals("title: title, author: author, isbn: 978-4-295-00762-3, beginDate: 2025-01-01, finishDate: 2025-01-01", book.toString());
    }

    @Test
    @DisplayName("日付データがない時の表示テスト")
    public void testBookInfo_NoDate() {
        Book book = new Book("title", "author", Isbn.create("978-4-295-00762-3"), ReadingDate.NO_DATA, ReadingDate.NO_DATA);
        assertEquals("title: title, author: author, isbn: 978-4-295-00762-3, beginDate: データがありません, finishDate: データがありません", book.toString());
    }

    @Test
    @DisplayName("日付入力のフォーマットエラーテスト")
    public void testBookInfo_MismatchDate() {
        assertThrows(IllegalArgumentException.class, () -> new Book("title", "author", Isbn.create("978-4-295-00762-3"), ReadingDate.create("aaaa"), ReadingDate.NO_DATA));
    }
}