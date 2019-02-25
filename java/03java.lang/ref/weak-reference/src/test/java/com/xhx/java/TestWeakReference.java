package com.xhx.java;

import com.xhx.java.entity.User;
import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用，当一个对象仅被弱引用指向，GC运行时，这个对象会被回收
 */
public class TestWeakReference {

    /**
     * 构造函数一个参数  T referent 代表弱引用的对象
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        WeakReference<User> reference = new WeakReference<>( new User("12-3-ds-s","小小",18));
        System.out.println(reference.get());
        System.gc();
        Thread.sleep(2000);
        System.out.println(reference.get());
        /**
         * com.xhx.java.entity.User@8e24743
         * null
         */
    }

    /**
     * 构造函数两个参数 T referent,
     * ReferenceQueue<? super T> q  对象被回收后，会把WeakReference或者实现类放入到这个队列中
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        ReferenceQueue queue = new ReferenceQueue();
        WeakReference<User> reference = new WeakReference<>(new User("12-3-ds-s", "小小", 18), queue);
        System.out.println("queue:" + queue.poll());
        System.out.println("reference:" + reference);
        System.out.println(reference.get());
        System.gc();
        System.out.println("==================");
        Thread.sleep(2000);
        System.out.println("queue:" + queue.poll());
        System.out.println(reference.get());
    }
}
