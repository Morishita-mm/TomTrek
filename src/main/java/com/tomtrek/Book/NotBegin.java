package com.tomtrek.Book;

public class NotBegin implements BookStatus {
    private NotBegin() {
    }

    
    /** 
     * @return NotBegin
     */
    static NotBegin create() {
        return new NotBegin();
    }

    @Override
    public String toString() {
        return "NOT BEGIN";
    }
}