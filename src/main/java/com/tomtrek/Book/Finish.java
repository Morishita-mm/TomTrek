package com.tomtrek.Book;

public class Finish implements BookStatus {
    private Finish() {
    }

    
    /** 
     * @return Finish
     */
    static Finish create() {
        return new Finish();
    }

    @Override
    public String toString() {
        return "FINISH";
    }
}