package com.xhx.designpattern;

import java.util.concurrent.Future;

public class FruitFactory3 {

    public static Fruit getFruit(String type) throws Exception {
        Class fruit = Class.forName(type);
        return (Fruit)fruit.newInstance();
    }
}
