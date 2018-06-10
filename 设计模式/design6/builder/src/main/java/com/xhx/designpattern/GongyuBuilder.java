package com.xhx.designpattern;

import com.xhx.designpattern.entity.House;

public class GongyuBuilder implements HouseBuilder {
    House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("公寓--->地板");
    }

    @Override
    public void makeWall() {
        house.setWall("公寓--->墙");
    }

    @Override
    public void makeHousetop() {
        house.setHousetop("公寓--->房顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
