package com.xhx.designpattern.observer;

import com.xhx.designpattern.entity.Observable;

public interface Observer {
    /**
     * 被观察者会回调这个函数
     * @param observable
     * @param object
     */
    void update(Observable observable, Object object);
}
