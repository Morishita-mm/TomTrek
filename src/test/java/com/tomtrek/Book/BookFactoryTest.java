package com.tomtrek.Book;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookFactoryTest {

    @Test
    void testCreateNewBook() {
        Book book = BookFactory.createNewBook("Title1", "Author1", "978-3-16-148410-0");
        assertNotNull(book);
        assertEquals(
                "title: Title1, author: Author1, isbn: 978-3-16-148410-0, beginDate: データがありません, finishDate: データがありません, status: NOT BEGIN",
                book.toString());
    }

    @Test
    void testCreateReadingBook() {
        ReadingDate beginDate = ReadingDate.create("2023-01-01");
        Book book = BookFactory.createReadingBook("Title2", "Author2", "978-3-16-148410-1", beginDate);
        assertNotNull(book);
        assertEquals(
                "title: Title2, author: Author2, isbn: 978-3-16-148410-1, beginDate: 2023-01-01, finishDate: データがありません, status: READING",
                book.toString());
    }

    @Test
    void testCreateFinishedBook() {
        ReadingDate beginDate = ReadingDate.create("2023-01-01");
        ReadingDate finishDate = ReadingDate.create("2023-02-01");
        Book book = BookFactory.createFinishedBook("Title3", "Author3", "978-3-16-148410-2", beginDate, finishDate);
        assertNotNull(book);
        assertEquals(
                "title: Title3, author: Author3, isbn: 978-3-16-148410-2, beginDate: 2023-01-01, finishDate: 2023-02-01, status: FINISH",
                book.toString());
    }
}
