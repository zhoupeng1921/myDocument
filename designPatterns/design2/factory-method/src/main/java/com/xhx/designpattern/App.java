package com.xhx.designpattern;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * 简单工厂模式，增加新类都需要修改原来的工厂
     * 工厂方法模式把工厂定义为接口，增加新类同样增加具体工厂类
     * @param args
     */
    public static void main( String[] args )
    {
        //获得AppleFactory
        FruitFactory fruitFactory = new AppleFactory();
        Fruit apple = fruitFactory.getFruit();
        apple.get();

        //获得BananaFactory
        FruitFactory fruitFactory1 = new BananaFactory();
        Fruit banana = fruitFactory1.getFruit();
        banana.get();
    }
}
