package com.xhx.designpattern;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        Fruit apple1 = new Apple();
        Fruit banana1 = new Banana();

        apple1.get();
        banana1.get();

        System.out.println("-------------");


        //第一个工厂
        Fruit apple2 = FruitFactory.getApple();
        Fruit banana2 = FruitFactory.getBanana();
        apple2.get();
        banana2.get();
        System.out.println("-------------");

        //第二个工厂
        Fruit apple = FruitFactory2.getFruit("apple");
        apple.get();
        System.out.println("-------------");


        //第三个工厂
        Fruit fruit = FruitFactory3.getFruit(Apple.class.getName());
        fruit.get();
        System.out.println("-------------");


    }

}
