package com.tomtrek.Book;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsbnTest {
    @Test
    @DisplayName("ISBN形式のテスト")
    public void testCreateIsbn() {
        Isbn isbn = Isbn.create("978-4-295-00762-3");
        assertEquals("978-4-295-00762-3", isbn.toString());
    }

    @Test
    @DisplayName("ISBN形式でない入力を受けた時のテスト")
    public void testCreateIsbn_wrongFormat() {
        assertThrows(IllegalArgumentException.class, () -> Isbn.create("aaaa"));
    }

    @Test
    @DisplayName("ISBNの等価性テスト")
    public void testIsbnEquals() {
        Isbn isbn1 = Isbn.create("978-4-295-00762-3");
        Isbn isbn2 = Isbn.create("978-4-295-00762-3");
        Isbn isbn3 = Isbn.create("111-1-111-11111-1");

        assertEquals(isbn1, isbn2);
        assertNotEquals(isbn1,isbn3);
    }

    @Test
    @DisplayName("ISBNのランダム生成テスト")
    public void testRandomCreateIsbn() {
        assertDoesNotThrow(() -> Isbn.randomCreate());
    }
}
