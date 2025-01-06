package com.tomtrek.Cli;

public class Exit implements Menu{

    private static final Exit instance = new Exit();

    private Exit() {}

    public static Exit getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println("終了します");
    }

}
