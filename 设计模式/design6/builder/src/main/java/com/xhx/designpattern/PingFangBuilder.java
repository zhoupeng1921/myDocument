package com.xhx.designpattern;

import com.xhx.designpattern.entity.House;

/**
 * 平房工程队
 */
public class PingFangBuilder implements HouseBuilder{
   House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("平房-->地板");
    }

    @Override
    public void makeWall() {
        house.setWall("平房-->墙");
    }

    @Override
    public void makeHousetop() {
        house.setHousetop("平房-->房顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
