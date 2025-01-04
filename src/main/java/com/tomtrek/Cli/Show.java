package com.tomtrek.Cli;

public class Show implements Menu{

    private static final Show instance = new Show();

    private Show() {}

    public static Show getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println("表示します");
    }

}