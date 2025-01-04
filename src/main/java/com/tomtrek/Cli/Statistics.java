package com.tomtrek.Cli;

public class Statistics implements Menu{

    private static final Statistics instance = new Statistics();

    private Statistics() {}

    public static Statistics getInstance() {
        return instance;
    }
    
    @Override
    public void execute() {
        System.out.println("統計情報を表示します");
    }

}
