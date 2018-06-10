package com.xhx.designpattern.entity;

/**
 * 装饰者，会飞的car
 */
public class FlyCar extends DecoratorCar{

    public FlyCar(Car car){
        super(car);
    }

    public void run() {
        fly();
        this.getCar().run();
    }
    private void fly(){
        System.out.println("车会飞");
    }
}
