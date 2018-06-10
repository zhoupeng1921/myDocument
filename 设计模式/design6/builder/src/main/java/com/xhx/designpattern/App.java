package com.xhx.designpattern;

import com.xhx.designpattern.entity.House;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //直接造房子
//        House house=new House();
//        house.setFloor("地板");
//        house.setHousetop("房顶");
//        house.setWall("墙");

        //由工程对来修
        //HouseBuilder builder = new PingFangBuilder();
        HouseBuilder builder = new GongyuBuilder();
//        builder.makeFloor();
//        builder.makeHousetop();
//        builder.makeWall();


        //由设计者来做
        HouseDirecter directer = new HouseDirecter(builder);
        directer.makeHourse();
        House house = builder.getHouse();


        System.out.println(house.getFloor());
        System.out.println(house.getHousetop());
        System.out.println(house.getWall());
    }
}
