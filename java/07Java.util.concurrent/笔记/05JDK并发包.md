# JDK并发包

## 各种同步控制工具的使用

- ReentrantLock
  - 可重入
  - 可中断
  - 可限时
  - 公平锁
- Condition
- Semaphore
- ReadWriteLock
- CountDownLatch
- CyclicBarrier
- LockSupport
- RenntrantLock的实现

## ConcurrentHashMap

当期望许多线程访问一个给定的collection时，ConcurrentHashMap通常优于HashMap，ConcurrentSkipListMap通常优于TreeMap。当期望读数和遍历远远大于列表的更新数时，CopyOnWriteArrayList优于同步的ArrayList

