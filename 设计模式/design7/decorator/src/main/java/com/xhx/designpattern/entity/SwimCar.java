package com.xhx.designpattern.entity;

/**
 * 装饰者，会游泳的car
 */
public class SwimCar extends DecoratorCar {

    public SwimCar(Car car){
        super(car);
    }

    public void run() {
        swim();
        this.getCar().run();
    }
    private void swim(){
        System.out.println("车会游泳");
    }
}
