package com.xhx.designpattern;

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
