package com.xhx.java;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆溢出   设置堆大小值     dump出当前的内存堆转储快照
 * >java  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError com.xhx.java.App
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to java_pid807288.hprof ...
 * Heap dump file created [28696795 bytes in 0.071 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *         at java.base/java.util.Arrays.copyOf(Arrays.java:3720)
 *         at java.base/java.util.Arrays.copyOf(Arrays.java:3689)
 *         at java.base/java.util.ArrayList.grow(ArrayList.java:237)
 *         at java.base/java.util.ArrayList.grow(ArrayList.java:242)
 *         at java.base/java.util.ArrayList.add(ArrayList.java:485)
 *         at java.base/java.util.ArrayList.add(ArrayList.java:498)
 *         at com.xhx.java.App.main(App.java:13)
 */
public class App {
//    public static void main(String[] args) {
//        List<Object> list = new ArrayList<>();
//        while (true){
//            list.add(new Object());
//        }
//    }

    byte[] byteArray = new byte[1*1024*1024];//1M

    public static void main(String[] args) {
        List<App> appLis = new ArrayList<>();
        for(int i = 1;i<=40;i++){
            appLis.add(new App());
        }
    }
}
