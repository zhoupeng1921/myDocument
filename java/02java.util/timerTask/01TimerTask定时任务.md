# TimerTask定时任务

## 1. 介绍

`java.util.TimerTask`是一个被Timer类执行的任务。继承`Runnable`接口



## 2. 类变量

有下面四种状态：

```java
    int state = VIRGIN;

    static final int VIRGIN = 0;

    static final int SCHEDULED   = 1;

    static final int EXECUTED    = 2;

    static final int CANCELLED   = 3;
```

`VIRGIN`：初始化状态，任务还没有被执行

`SCHEDULED`：任务已经计划执行(如果不是一个重复执行的任务，它就还没有被执行过)

`EXECUTED`：非重复性任务已经被执行了（或者正在执行），并且没有被取消

`CANCELLED`：任务已经被取消（调用TimerTask.cancel）



`lock`：控制访问TimerTask内部的锁

```java
 final Object lock = new Object();
```



`nextExecutionTime`：下一次任务执行的时间，如果是重复性任务，会在每一个任务执行前更新

```java
long nextExecutionTime;
```



`period`：重复性任务的周期时间，一个正值表明是固定频率`fixed-rate`执行，负值表明固定延迟`fixed-delay`执行，0表示非重复性任务

```java
 long period = 0;
```

## 3.成员方法

构造方法：

```java
  protected TimerTask() {
   }
```

run()：timerTask需要执行的具体操作，需要重写

```java
public abstract void run();
```



cancel()：取消任务，如果任务正在执行中，会执行完。

```java
 public boolean cancel() {
        synchronized(lock) {
            boolean result = (state == SCHEDULED);
            state = CANCELLED;
            return result;
        }
    }
```



scheduledExecutionTime()：最近一次执行时间

```java
public long scheduledExecutionTime() {
        synchronized(lock) {
            return (period < 0 ? nextExecutionTime + period
                               : nextExecutionTime - period);
        }
    }
```

