package com.tomtrek.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {
    @Test
    @DisplayName("BookStatusのテスト")
    public void testStatusToString() {
        assertEquals("NOT BEGIN", new NotBegin().toString());
        assertEquals("READING", new Reading().toString());
        assertEquals("FINISH", new Finish().toString());
    }
}
