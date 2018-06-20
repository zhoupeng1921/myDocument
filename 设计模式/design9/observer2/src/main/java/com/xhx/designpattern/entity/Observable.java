package com.xhx.designpattern.entity;

import com.xhx.designpattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    List<Observer> observerList;

    public Observable(){
        observerList = new ArrayList<>();
    }

    /**
     * 添加观察者
     * @param observer
     */
    public synchronized void addObserver(Observer observer){
        if(observer==null){
            throw new NullPointerException();
        }
        if(!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    /**
     * 删除所有观察者
     */
    public synchronized void deleteObservers() {
        observerList.clear();
    }

    /**
     * 删除一个观察者
     * @param observer
     */
    public synchronized void deleteObserver(Observer observer){
        observerList.remove(observer);
    }

    /**
     * 通知观察者
     * @param object
     */
    public void notifyObservers(Object object){
        observerList.forEach(observer -> observer.update(this,object));
    }


}
