package com.tomtrek.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {
    @Test
    @DisplayName("BookStatusのテスト")
    public void testStatusToString() {
        assertEquals("NOT BEGIN", NotBegin.create().toString());
        assertEquals("READING", Reading.create().toString());
        assertEquals("FINISH", Finish.create().toString());
    }
}
