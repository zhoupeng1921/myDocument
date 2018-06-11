package com.xhx.designpattern;

import com.xhx.designpattern.entity.Car;
import com.xhx.designpattern.entity.CommonCar;
import com.xhx.designpattern.entity.FlyCar;
import com.xhx.designpattern.entity.SwimCar;


public class App {
    public static void main(String[] args) {
        //普通car
        Car commonCar = new CommonCar();
        commonCar.run();
        System.out.println("------------");

        //会飞的car
        Car flyCar = new FlyCar(commonCar);
        flyCar.run();
        System.out.println("------------");

        //会游泳的car
        Car swimCar = new SwimCar(commonCar);
        swimCar.run();
        System.out.println("------------");

        //既会飞又会游泳的car
        Car flySwimCar = new SwimCar(flyCar);
        flySwimCar.run();

    }
}
