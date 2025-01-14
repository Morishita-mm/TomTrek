package com.tomtrek.Book;

import java.time.LocalDate;

class ReadingDate {
    private final LocalDate date;
    static final ReadingDate NO_DATA = new ReadingDate(LocalDate.of(1900,1,1));

    private ReadingDate(LocalDate date) throws IllegalArgumentException {
        this.date = date;

        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("今日以前の日付を指定してください");
        }
    }

    
    /** 
     * @param rowDate yyyy-mm-dd形式の日付文字列
     * @return ReadingDate ReadingDateのインスタンス
     */

    static ReadingDate create(String rowDate) {
        try {
            LocalDate date = LocalDate.parse(rowDate);
            return new ReadingDate(date);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("yyyy-mm-dd形式で日付を入力してください");
        }
    }

    
    /** 
     * @return Stringm データなしの場合は"データがありません"と表示
     */
    @Override
    public String toString() {
        if (this.equals(NO_DATA)) return "データがありません";
        return this.date.toString();
    }
}
