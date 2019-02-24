package com.xhx.designpattern;

/**
 * 抽象工厂，可以在工厂中直接获取各种类型产品，（工厂类中可以直接看出能生产多少产品）
 * 解决了工厂方法模式不知道能生产多少类型产品问题，（每个工厂对应一种产品，不知道有多少工厂）
 *
 * 结局了编写代码的人与调用代码的人的痛处
 */
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
