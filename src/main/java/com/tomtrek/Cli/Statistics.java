package com.tomtrek.Cli;

import java.util.Scanner;

public class Statistics implements Menu{

    private static final Statistics instance = new Statistics();
    private final Scanner scanner = new Scanner(System.in);

    private Statistics() {}

    public static Statistics getInstance() {
        return instance;
    }
    
    // TODO どの統計情報を表示するのか聞く
    // 1. 登録した本の冊数
    // 2. 現在読んでいる本の冊数
    // 3. 現在読み終わった本の冊数
    // 4. まだ読み始めていない本の冊数
    // 5. メニューに戻る
    // 表示が終わった他の情報を確認するか聞く
    // 他の情報を確認する場合統計情報選択画面の表示に戻る
    // しない場合は、メニュー画面に戻る
    @Override
    public void execute() {
        System.out.println("統計情報を表示します");
    }

}
