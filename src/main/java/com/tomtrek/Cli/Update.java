package com.tomtrek.Cli;

public class Update implements Menu{

    private static final Update instance = new Update();

    private Update() {}

    public static Update getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println("本の情報を更新します");
    }
    
}
