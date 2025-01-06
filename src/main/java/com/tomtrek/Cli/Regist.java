package com.tomtrek.Cli;

import java.util.Scanner;

import com.tomtrek.Book.BookManager;

public class Regist implements Menu {
    private final static Regist regist = new Regist();
    private final BookManager bookManager = BookManager.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    private Regist() {
    }

    public static Regist getInstance() {
        return regist;
    }

    // TODO 本のタイトル、著者、ISBNを順に入力してもらい本を登録する
    // 操作が終了した場合、その本の情報を更新するのか聞く
    // 更新する場合は、Updateクラスを使って情報更新に映る
    // 更新しない場合はメニュー画面に戻る
    // TODO 入力を別のクラスに一時保存してからそのインスタンスをBookManagerに渡して
    // BooKクラスのインスタンスにしてもらう形の方に変更する
    @Override
    public void execute() {
        System.out.println("本を登録します");
        System.out.printf("タイトル\t> ");
        String title = scanner.next();
        System.out.printf("著者\t> ");
        String author = scanner.next();
        System.out.printf("ISBN\t> ");
        String isbn = scanner.next();
        bookManager.createBook(title, author, isbn);
    }


}
