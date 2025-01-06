package com.tomtrek.Cli;

import java.util.Scanner;

import com.tomtrek.Book.Book;
import com.tomtrek.Book.BookManager;
import com.tomtrek.Book.Finished;
import com.tomtrek.Book.NotBegin;
import com.tomtrek.Book.Reading;

public class Update implements Menu{

    private static final Update instance = new Update();
    private final BookManager bookManager = BookManager.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    private Update() {}

    public static Update getInstance() {
        return instance;
    }

    // TODO 本のIDを入力してもらい、その本の情報を更新する
    // 更新が終了した場合、「更新が完了しました」のメッセージと、更新された本の情報をすべて表示してメニュー画面に戻る
    @Override
    public void execute() {
        System.out.println("本の情報を更新します");
        System.out.println("対象のIDを入力してください");
        System.out.print("ID > ");
        int targetId = scanner.nextInt();
        Book targetBook = bookManager.searchBooksById(targetId);
        System.out.println("本をどの状態に変更しますか？");
        System.out.println("1. 未読");
        System.out.println("2. 読中");
        System.out.println("3. 読了");
        int changeStatus = scanner.nextInt();

        switch(changeStatus) {
            case 1 -> bookManager.updateStatus(targetBook, NotBegin.NOT_BEGIN());
            case 2 -> bookManager.updateStatus(targetBook, Reading.READING());
            case 3 -> bookManager.updateStatus(targetBook, Finished.FINISHED());
            default -> throw new IllegalArgumentException("不正な値です");
        }
    }
    
}
