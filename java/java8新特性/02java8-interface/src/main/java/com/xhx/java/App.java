package com.xhx.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Fly birdFly = Fly.getInstance();
        birdFly.fly();
        birdFly.wings();
        Fly planFly = Fly.getInstance2();
        planFly.fly();
        planFly.wings();
    }
}
