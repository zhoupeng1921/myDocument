# Timer定时器

## 1.介绍

`java.util.Timer`可以设置一个后台线程，有计划的执行一次或者重复的按规律执行。每一个Timer是一个后台线程，按顺序执行所有的timer的任务。所以Timer不要执行耗时的操作，否则会造成任务堆积。

Timer类是线程安全的

多线程任务调度，请使用：`java.util.concurrent.ScheduledThreadPoolExecutor`，可以完全取代`Timer`和`TimerTask`

注意：所有的构造方法开启一个timer线程

这里面用到了二叉树优先级队列



## 2. 内部类TaskQueue

`TaskQueue`：有优先级的时间任务队列，按照执行时间先后排序。内部用平衡二叉堆实现

### 2.1 类属性

`queue`:队列数组，按照TimerTask的`nextExecutionTime`进行优先级比较

```java
private TimerTask[] queue = new TimerTask[128];
```

`size`:优先级队列中的任务数量，任务存储在queue[1]到queue[size]

### 2.2 类方法

`size()`:返回目前队列中任务的数量

```java
	int size() {
        return size;
    }
```

`add(TimerTask task)`:添加任务

```java
    void add(TimerTask task) {
        // Grow backing store if necessary
        if (size + 1 == queue.length)
            queue = Arrays.copyOf(queue, 2*queue.length);

        queue[++size] = task;
        fixUp(size);
    }
    //添加一个元素后，堆的自我调整，进行上浮操作
    private void fixUp(int k) {
        while (k > 1) {
            int j = k >> 1;
            if (queue[j].nextExecutionTime <= queue[k].nextExecutionTime)
                break;
            TimerTask tmp = queue[j];  queue[j] = queue[k]; queue[k] = tmp;
            k = j;
        }
    }

```

`getMin()`：获取堆顶元素

```java
	TimerTask getMin() {
        return queue[1];
    }
```

`get(int i)`：返回指定下标的元素

```java
    TimerTask get(int i) {
        return queue[i];
    }
```

`removeMin()`：移除堆顶元素

```
    void removeMin() {
        queue[1] = queue[size];
        queue[size--] = null;  // Drop extra reference to prevent memory leak
        fixDown(1);
    }
    private void fixDown(int k) {
        int j;
        while ((j = k << 1) <= size && j > 0) {
            if (j < size &&
                queue[j].nextExecutionTime > queue[j+1].nextExecutionTime)
                j++; // j indexes smallest kid
            if (queue[k].nextExecutionTime <= queue[j].nextExecutionTime)
                break;
            TimerTask tmp = queue[j];  queue[j] = queue[k]; queue[k] = tmp;
            k = j;
        }
    }
```

​	移除堆顶元素后，尾元素移到顶元素，然后进行下沉调整。

`quickRemove(int i)`：移除第i个元素

```java
    void quickRemove(int i) {
        assert i <= size;

        queue[i] = queue[size];
        queue[size--] = null;  // Drop extra ref to prevent memory leak
    }
```

`rescheduleMin(long newTime)`：重新设置顶部元素下次执行时间

```java
    void rescheduleMin(long newTime) {
        queue[1].nextExecutionTime = newTime;
        fixDown(1);
    }
```

`isEmpty()`：判断空

```java
    boolean isEmpty() {
        return size==0;
    }
```

`clear()`：清空队列

```java
    void clear() {
        // Null out task references to prevent memory leak
        for (int i=1; i<=size; i++)
            queue[i] = null;

        size = 0;
    }
```

`heapify()`：初始化堆

```java
    void heapify() {
        for (int i = size/2; i >= 1; i--)
            fixDown(i);
    }
```

## 3. 内部类TimerThread

这个类实现了定时器任务的执行线程，在任务队列上等待，并且执行任务，重新调整重复执行的任务，移除取消的任务和已经执行的非重复性任务。继承Thread类

### 3.1 类属性

`newTasksMayBeScheduled`：当定时器没有有效的引用的时候，设置为false

```java
   boolean newTasksMayBeScheduled = true;
```

`queue`：定时器的队列，不引用Timer对象，是因为会造成循环引用，Timer无法被回收，线程也会一直存在下去

```java
    private TaskQueue queue;
```



### 3.2 类方法

构造方法：传入任务队列

```
    TimerThread(TaskQueue queue) {
        this.queue = queue;
    }
```

`run()`：线程具体的执行

```java
 public void run() {
        try {
            mainLoop();
        } finally {
            // Someone killed this Thread, behave as if Timer cancelled
            synchronized(queue) {
                newTasksMayBeScheduled = false;
                queue.clear();  // Eliminate obsolete references
            }
        }
    }

    /**
     * The main timer loop.  (See class comment.)
     */
    private void mainLoop() {
        while (true) {
            try {
                TimerTask task;
                boolean taskFired;
                synchronized(queue) {
                    // Wait for queue to become non-empty
                    while (queue.isEmpty() && newTasksMayBeScheduled)
                        queue.wait();
                    if (queue.isEmpty())
                        break; // Queue is empty and will forever remain; die

                    // Queue nonempty; look at first evt and do the right thing
                    long currentTime, executionTime;
                    task = queue.getMin();
                    synchronized(task.lock) {
                        if (task.state == TimerTask.CANCELLED) {
                            queue.removeMin();
                            continue;  // No action required, poll queue again
                        }
                        currentTime = System.currentTimeMillis();
                        executionTime = task.nextExecutionTime;
                        if (taskFired = (executionTime<=currentTime)) {
                            if (task.period == 0) { // Non-repeating, remove
                                queue.removeMin();
                                task.state = TimerTask.EXECUTED;
                            } else { // Repeating task, reschedule
                                queue.rescheduleMin(
                                  task.period<0 ? currentTime   - task.period
                                                : executionTime + task.period);
                            }
                        }
                    }
                    if (!taskFired) // Task hasn't yet fired; wait
                        queue.wait(executionTime - currentTime);
                }
                if (taskFired)  // Task fired; run it, holding no locks
                    task.run();
            } catch(InterruptedException e) {
            }
        }
    }
```

这一大段代码主要做了三件事：

1. 在队列中获取要执行的任务
2. 如果任务已取消或者是非重复执行的任务，在队列中去除
3. 执行任务

## 4. Timer类

### 4.1 类属性

`queue`：任务队列

```java
 private final TaskQueue queue = new TaskQueue();
```

`thread`：定时器的线程

```java
private final TimerThread thread = new TimerThread(queue);
```

`nextSerialNumber`：线程名字的id

```java
private static final AtomicInteger nextSerialNumber = new AtomicInteger(0);
private static int serialNumber() {
    return nextSerialNumber.getAndIncrement();
}
```

### 4.2 方法

构造方法

```java
    //无参
    public Timer() {
        this("Timer-" + serialNumber());
    }
    //是否为后台进程
    public Timer(boolean isDaemon) {
        this("Timer-" + serialNumber(), isDaemon);
    }
    //用指定名字创建线程
    public Timer(String name) {
        thread.setName(name);
        thread.start();
    }
    public Timer(String name, boolean isDaemon) {
        thread.setName(name);
        thread.setDaemon(isDaemon);
        thread.start();
    }

```

`schedule`

```java
    //指定任务和延迟时间
    public void schedule(TimerTask task, long delay) {
        if (delay < 0)
            throw new IllegalArgumentException("Negative delay.");
        sched(task, System.currentTimeMillis()+delay, 0);
    }
    //指定任务和执行时时间
    public void schedule(TimerTask task, Date time) {
        sched(task, time.getTime(), 0);
    }
    //指定任务，第一次执行延迟，以后每次执行周期 ms
	public void schedule(TimerTask task, long delay, long period) {
        if (delay < 0)
            throw new IllegalArgumentException("Negative delay.");
        if (period <= 0)
            throw new IllegalArgumentException("Non-positive period.");
        sched(task, System.currentTimeMillis()+delay, -period);
    }
	//指定任务，第一次执行时间，以后每次执行周期 ms
    public void schedule(TimerTask task, Date firstTime, long period) {
        if (period <= 0)
            throw new IllegalArgumentException("Non-positive period.");
        sched(task, firstTime.getTime(), -period);
    }

```



`scheduleAtFixedRate`：

```java
	//指定任务，第一次执行延迟，以后每次执行周期 ms
    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        if (delay < 0)
            throw new IllegalArgumentException("Negative delay.");
        if (period <= 0)
            throw new IllegalArgumentException("Non-positive period.");
        sched(task, System.currentTimeMillis()+delay, period);
    }
	//指定任务，第一次执行时间，以后每次执行周期 ms
    public void scheduleAtFixedRate(TimerTask task, Date firstTime,
                                    long period) {
        if (period <= 0)
            throw new IllegalArgumentException("Non-positive period.");
        sched(task, firstTime.getTime(), period);
    }
```



`schedule`方法和`scheduleAtFixedRate`方法的不同，需要看`TimerThread`类的`mainLoop`方法，有下面一条语句，`schedule`的下次执行时间按照当前时间来算的，而`scheduleAtFixedRate`的下次执行时间按照最后一次计算出的执行时间来算的，`scheduleAtFixedRate`更加注重频率，`schedule`更加注重间隔时间

```java
queue.rescheduleMin(task.period<0 ? currentTime- task.period : executionTime + task.period);
```



`sched`：任务加入队列，

```java
private void sched(TimerTask task, long time, long period) {
        if (time < 0)
            throw new IllegalArgumentException("Illegal execution time.");

        // Constrain value of period sufficiently to prevent numeric
        // overflow while still being effectively infinitely large.
        if (Math.abs(period) > (Long.MAX_VALUE >> 1))
            period >>= 1;

        synchronized(queue) {
            if (!thread.newTasksMayBeScheduled)
                throw new IllegalStateException("Timer already cancelled.");

            synchronized(task.lock) {
                if (task.state != TimerTask.VIRGIN)
                    throw new IllegalStateException(
                        "Task already scheduled or cancelled");
                task.nextExecutionTime = time;
                task.period = period;
                task.state = TimerTask.SCHEDULED;
            }

            queue.add(task);
            if (queue.getMin() == task)
                queue.notify();
        }
    }
```

`cancel`：中断定时器，不会影响正在执行的任务

```java
    public void cancel() {
        synchronized(queue) {
            thread.newTasksMayBeScheduled = false;
            queue.clear();
            queue.notify();  // In case queue was already empty.
        }
    }
```

`purge`：移除所有队列中取消的任务

```java
     public int purge() {
         int result = 0;

         synchronized(queue) {
             for (int i = queue.size(); i > 0; i--) {
                 if (queue.get(i).state == TimerTask.CANCELLED) {
                     queue.quickRemove(i);
                     result++;
                 }
             }

             if (result != 0)
                 queue.heapify();
         }

         return result;
     }
```

