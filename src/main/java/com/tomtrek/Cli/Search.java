package com.tomtrek.Cli;

import java.util.List;
import java.util.Scanner;

import com.tomtrek.Book.Book;
import com.tomtrek.Book.BookManager;

public class Search implements Menu{
    private final BookManager bookManager = BookManager.getInstance();
    private static final Search instance = new Search();
    private final Scanner scanner = new Scanner(System.in);

    private Search() {}

    public static Search getInstance() {
        return instance;
    }

    // TODO タイトルを入力として受け取り、入力された文字列を含むタイトルを持つ本を列挙する
    // なければ「対象の本が登録されていません」と出力する
    // あった場合は、本の情報をすべて表示する
    // 操作が一回終わったらメニュー画面に戻る
    // TODO 結果表示のUIをもう少し見やすくなるように調整する
    @Override
    public void execute() {
        System.out.println("本を検索します");
        System.out.println("タイトルの一部又は全てを入力してください");
        System.out.print("検索 > ");
        String targetTitle = scanner.next();
        List<Book> result = bookManager.searchBooksByTitle(targetTitle);
        if (result.size() > 0) {
            for(Book book: result) {
                System.out.println(book);
            }
        } else {
            System.out.println("対象の本が登録されていません");
        }
    }

}