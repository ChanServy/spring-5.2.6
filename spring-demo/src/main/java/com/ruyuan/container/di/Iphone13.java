package com.ruyuan.container.di;

public class Iphone13 implements Phone{

    @Override
    public void playGame(String name) {
        System.out.println(name + "打开Iphone13，玩王者荣耀");
    }
}
