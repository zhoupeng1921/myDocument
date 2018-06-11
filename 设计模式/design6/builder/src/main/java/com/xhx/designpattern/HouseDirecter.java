package com.xhx.designpattern;

public class HouseDirecter {

    //其实也没必要加一个属性，构造函数传参，
    //makeHourse方法加个入参就可以了
    private HouseBuilder builder;

    public HouseDirecter(HouseBuilder builder){
        this.builder=builder;
    }

    public void makeHourse(){
        builder.makeFloor();
        builder.makeWall();
        builder.makeHousetop();
    }



}
