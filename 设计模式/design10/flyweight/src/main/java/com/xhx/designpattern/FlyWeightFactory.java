package com.xhx.designpattern;

import java.util.concurrent.ConcurrentHashMap;

/**
 * xuhaixing
 * 2018/6/21 23:09
 **/
public class FlyWeightFactory {
    private static ConcurrentHashMap<String, FlyWeight> flyWeights = new ConcurrentHashMap<String, FlyWeight>();

    /**
     * 通过内部状态name保存对象，如果外部状态改变，会导致线程不安全问题
     * @param name
     * @return
     */
    public static  FlyWeight getFlyWeight(String name){
        if(flyWeights.get(name)==null){
            synchronized (flyWeights){
                if(flyWeights.get(name)==null){
                    FlyWeight flyWeight = new ConcreateFlyWeight(name);
                    flyWeights.put(name,flyWeight);
                }
            }
        }
        return flyWeights.get("name");
    }
}
