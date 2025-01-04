package com.tomtrek.Cli;

public class Regist implements Menu {
    private final static Regist regist = new Regist();

    private Regist() {
    }

    public static Regist getInstance() {
        return regist;
    }

    @Override
    public void execute() {
        System.out.println("登録します");
    }
}
