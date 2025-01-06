package com.tomtrek.Cli;

import java.util.Scanner;

public class Manager {
    private final Menu menu;
    private final Scanner scanner = new Scanner(System.in);

    private Manager() {
        showMenu();
        int choice = scanner.nextInt();
        switch(choice) {
            case 1 -> menu = Regist.getInstance();
            case 2 -> menu = Search.getInstance();
            case 3 -> menu = Update.getInstance();
            case 4 -> menu = Statistics.getInstance();
            case 5 -> menu = Exit.getInstance();
            default -> throw new IllegalArgumentException("不正な値です");
        }
    }
    
    public void execute() {
        if (menu != null) {
            try {
                menu.execute();
            } catch (Exception e) {
                System.out.println("エラーが発生しました");
                System.out.println("最初からやり直してください");
            }
        }
    }

    public static Manager MenuStart() {

        return new Manager();
    }

    private void showMenu() {
        System.out.printf(
        "=".repeat(30)+"%n"       +
        "1. 本を登録する%n"               +
        "2. 本を検索する%n"               + 
        "3. 読書ステータスを更新する%n"     + 
        "4. 統計情報を表示する%n"          +
        "5. 終了%n"                      +
        "=".repeat(30)+"%n"
        );
        System.out.print("メニュー番号を入力してください >");
    }
}

