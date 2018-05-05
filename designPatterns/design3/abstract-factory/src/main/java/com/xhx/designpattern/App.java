package com.xhx.designpattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        FruitFactory fruitFactory = new NorthFruitFactory();
        Fruit apple = fruitFactory.getApple();
        apple.get();

        Fruit banana = fruitFactory.getBanana();
        banana.get();
    }
}
