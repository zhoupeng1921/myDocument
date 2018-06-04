package com.xhx.designpattern;


/**
 * 入参为实体类名称的字符串
 *
 * 缺点，每次增加一个新的实体类，都需要加一个判断
 */
public class FruitFactory2 {

    public static Fruit getFruit(String type) throws IllegalAccessException, InstantiationException {
        if(type.equalsIgnoreCase("apple")){
            return new Apple();
        } else if (type.equalsIgnoreCase("banana")) {
            return new Banana();
        }else {
            return null;
        }
    }
}
