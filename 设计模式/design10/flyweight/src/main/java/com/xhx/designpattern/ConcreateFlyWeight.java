package com.xhx.designpattern;

/**
 * xuhaixing
 * 2018/6/21 23:05
 * 享元具体类
 **/
public class ConcreateFlyWeight implements FlyWeight{

    //内部状态
    private String name;
    public ConcreateFlyWeight(String name){
        this.name=name;
    }
    //外部状态  externalState
    public void doing(String externalState) {
        System.out.println("name="+name+" exterState="+externalState);
    }
}
