package com.xhx.designpattern;


/**
 *    没有入参，通过方法名字，区分创建的实体类。
 *
 *     缺点，每次增加新的实体类，都需要加一个方法
 * */
public class FruitFactory {


    public static Fruit getApple(){
        return new Apple();
    }

    public  static Fruit getBanana(){
        return new Banana();
    }

}
