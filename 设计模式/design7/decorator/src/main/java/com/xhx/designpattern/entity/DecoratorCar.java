package com.xhx.designpattern.entity;

/**
 * 装饰者父类，继承Car是因为被装饰者也成了装饰者
 */
public abstract class DecoratorCar implements Car{

    private Car car;

    public DecoratorCar(Car car){
        this.car = car;
    }

    public abstract void run();

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
