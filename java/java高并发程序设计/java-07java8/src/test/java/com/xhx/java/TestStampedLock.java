package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.locks.StampedLock;


/**
 * StampedLock 读写锁
 * 读可以不阻塞写，ReadWriteLock的加强版
 */
public class TestStampedLock {

    @Test
    public void test01(){
        Point point = new Point();
        point.move(2.0,5.0);
        double v = point.distanceFromOrigin();
        System.out.println(v);

    }

}

class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    //写锁
    public void move(double x, double y) {
        long stamp = sl.writeLock();
        try {
            this.x += x;
            this.y += y;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        //乐观读
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!sl.validate(stamp)) {
            //悲观读
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return currentX+currentY;
    }

}