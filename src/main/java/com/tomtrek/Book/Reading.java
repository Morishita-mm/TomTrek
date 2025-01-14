package com.tomtrek.Book;

public class Reading implements BookStatus {
    private Reading() {
    }

    static Reading create() {
        return new Reading();
    }

    @Override
    public String toString() {
        return "READING";
    }
}