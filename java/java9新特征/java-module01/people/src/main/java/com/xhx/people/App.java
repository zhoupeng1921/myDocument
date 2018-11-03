package com.xhx.people;

import com.xhx.address.Address;
import com.xhx.cloth.Clothes;
//import com.xhx.other.Car;

public class App {
    public static void main(String[] args) {
        Clothes clothes = new Clothes();
        clothes.setId("3f-3faf-fdaa-54qfaf");
        clothes.setColor("red");
        clothes.setSize("3xl");
        System.out.println(clothes.toString());

        Address address = new Address();
        address.setContry("CN");
        address.setProvince("hebei");
        System.out.println(address.toString());

        //因为com.xhx.other没有 exports，所以Car类引不到
       //new Car()
    }
}
