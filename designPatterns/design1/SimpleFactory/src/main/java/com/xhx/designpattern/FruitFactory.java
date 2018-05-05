package com.xhx.designpattern;

public class FruitFactory {
    /*
    获得实例
     */

    public static Fruit getApple(){
        return new Apple();
    }

    public  static Fruit getBanana(){
        return new Banana();
    }

}
