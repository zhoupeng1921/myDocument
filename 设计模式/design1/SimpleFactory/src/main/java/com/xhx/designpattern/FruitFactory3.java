package com.xhx.designpattern;

/**
 * 通过反射
 *
 * 通过反射获取，新增实体类无影响
 */

public class FruitFactory3 {

    public static Fruit getFruit(String type) throws Exception {
        Class fruit = Class.forName(type);
        return (Fruit)fruit.newInstance();
    }
}
