package com.tomtrek.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {
    private Book bookNotBegin;
    private Book bookFinished;
    private Book bookReading;

    @BeforeEach
    public void setUp() {
        bookNotBegin = Book.createBookNotBegin("Effectivejava", "Joshua Bloch", "97846213032152");
        bookReading = Book.createBookReading("Effectivejava", "Joshua Bloch", "97846213032152", LocalDate.of(2024,12,1));
        bookFinished = Book.createBookFinished("EffectiveJava", "Joshua Bloch", "97846213032152", LocalDate.of(2024,12,1), LocalDate.of(2024,12,15));
    }

    @Test
    @DisplayName("Test toString()")
    public void testToString() {
        assertEquals("Book{id=1, title='Effectivejava', author='Joshua Bloch', isbn='97846213032152', beginReadingDate=null, finishedReadingDate=null, readingStatus=NOT_BEGIN}", bookNotBegin.toString());
        assertEquals("Book{id=2, title='Effectivejava', author='Joshua Bloch', isbn='97846213032152', beginReadingDate=2024-12-01, finishedReadingDate=null, readingStatus=READING}", bookReading.toString());
        assertEquals("Book{id=3, title='EffectiveJava', author='Joshua Bloch', isbn='97846213032152', beginReadingDate=2024-12-01, finishedReadingDate=2024-12-15, readingStatus=FINISHED}", bookFinished.toString());
    }

    @Test
    @DisplayName("Test compareTo()")
    public void testCompareTo() {
        assertEquals(0, bookNotBegin.compareTo(bookNotBegin));
        assertEquals(0, bookReading.compareTo(bookReading));
        assertEquals(0, bookFinished.compareTo(bookFinished));
        assertNotEquals(0, bookNotBegin.compareTo(bookReading));
        assertNotEquals(0, bookNotBegin.compareTo(bookFinished));
        assertNotEquals(0, bookReading.compareTo(bookFinished));
    }
    
}