package com.tomtrek;

import java.io.IOException;
import com.tomtrek.Cli.Manager;

// TODO 全体的に引数にfinalをつけて、メソッドの内部で変更が加えられていないことを明記する
public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            try {
                Manager manager = Manager.MenuStart();
                manager.execute();
            } catch(Exception e) {
                System.out.println("正しいメニュー番号を入力してください");
            }
        }
    }
}