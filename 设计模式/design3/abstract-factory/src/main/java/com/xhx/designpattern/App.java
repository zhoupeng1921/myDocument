package com.xhx.designpattern;


public class App 
{
    public static void main( String[] args )
    {

        //用来创建北方水果的工厂
        FruitFactory fruitFactory = new NorthFruitFactory();
        Fruit apple = fruitFactory.getApple();
        apple.get();

        Fruit banana = fruitFactory.getBanana();
        banana.get();
    }
}
