package com.xhx.designpattern;

/**
 * xuhaixing
 * 2018/6/30 11:33
 *
 * 外观对象,提供过了对子系统的封装，
 * 外部客户端通过调用外观对象对内部系统进行访问。避免子系统内部实现细节
 **/
public class Facade {
    private ModuleA moduleA;
    private  ModuleB moduleB;
    private ModuleC moduleC;
    public Facade(){
        moduleA = new ModuleA();
        moduleB = new ModuleB();
        moduleC = new ModuleC();
    }

    public void doABC(){
        moduleA.aMethod();
        moduleB.bMethod();
        moduleC.cMethod();
    }

    public void doAB(){
        moduleA.aMethod();
        moduleB.bMethod();
    }
    public void doAC(){
        moduleA.aMethod();
        moduleC.cMethod();
    }
}
