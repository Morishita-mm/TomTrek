package com.tomtrek.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {
    private Book bookFullData;
    private Book bookNoDate;

    @BeforeEach
    public void setUp() {
        bookFullData = new Book.Builder("title", "author", Isbn.create("978-4-295-00762-3"))
                .setBeginReadingDate(ReadingDate.create("2025-01-01"))
                .setFinishReadingDate(ReadingDate.create("2025-01-01"))
                .setStatus(Finish.create())
                .build();
        bookNoDate = new Book.Builder("title", "author", Isbn.create("978-4-295-00762-3")).build();
 
    }

    @Test
    @DisplayName("BookModelのtoStringメソッドテスト")
    public void testBookInfo() {
        assertEquals(
                "title: title, author: author, isbn: 978-4-295-00762-3, beginDate: 2025-01-01, finishDate: 2025-01-01, status: FINISH",
                bookFullData.toString());
    }

    @Test
    @DisplayName("日付データがない時の表示テスト")
    public void testBookInfo_NoDate() {
        assertEquals(
                "title: title, author: author, isbn: 978-4-295-00762-3, beginDate: データがありません, finishDate: データがありません, status: NOT BEGIN",
                bookNoDate.toString());
    }

    @Test
    @DisplayName("日付入力のフォーマットエラーテスト")
    public void testBookInfo_MismatchDate() {
        assertThrows(IllegalArgumentException.class, () -> new Book.Builder(
                "title",
                "author",
                Isbn.create("978-4-295-00762-3"))
                .setBeginReadingDate(ReadingDate.create("aaaa"))
                .build());
    }
}