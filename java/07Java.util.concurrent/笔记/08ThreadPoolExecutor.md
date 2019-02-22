# ThreadPoolExecutor

## 1. 介绍

用来创建线程池

## 2. 参数说明

| 参数                     | 说明                                                         |
| ------------------------ | ------------------------------------------------------------ |
| corePoolSize             | 核心线程数                                                   |
| maximumPoolSize          | 最大线程数                                                   |
| keepAliveTime            | 超过corePoolSize，allowCoreThreadTimeOut(true)也可以设置核心线程数的超时时间 |
| TimeUnit                 | keepAliveTime时间单位                                        |
| workQueue                | 阻塞任务队列                                                 |
| threadFactory            | 线程工厂                                                     |
| RejectedExecutionHandler | 线程超过maximumPoolSize+workQueue数量和时的拒绝策略          |

具体说明：

`corePoolSize`: 创建线程池后，默认情况下没有线程，有任务到来时才会逐个创建线程去执行，可以显示调用prestartAllCoreThreads()或者prestartCoreThread()来创建所有核心线程或一个线程

`maximumPoolSize`：最大线程数，当核心线程corePoolSize已满，阻塞队列workQueue已满时，会新建线程，直到最大线程数，若还有线程，表明超出线程池处理能力，会走拒绝策略RejectedExecutionHandler

`keepAliveTime`：当线程空闲时间达到keepAliveTime时，线程会被销毁，直到corePoolSize数量，如果如果allowCoreThreadTimeout设置为true，则核心线程空闲超时也会退出

`workQueue`：阻塞队列，核心线程数满时，任务会放入阻塞队列，阻塞队列满时，会创建新线程直到maximumPoolSize数量。线程池的排队策略与阻塞队列有关，可以看下`java.util.concurrent.BlockingQueue`的实现类，常用这几种：

```java
    ArrayBlockingQueue;
    LinkedBlockingQueue;
    SynchronousQueue;
    PriorityBlockingQueue
```

`threadFactory`： 线程工程，用来创建线程

`RejectedExecutionHandler`：任务超过maximumPoolSize+workQueue数量和时，要怎么做？

```
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务 
ThreadPoolExecutor.AbortPolicy:拒绝任务并抛出RejectedExecutionException异常。 
ThreadPoolExecutor.DiscardPolicy：拒绝任务，只是忽略掉任务，但是不抛出异常。 
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的未处理的任务，然后重试执行任务
```



## 3. 参数设置

`corePoolSize`： 假设处理每个任务需要taskTime秒，每个线程每秒可以处理1/taskTime个任务。如果系统每秒有tasks个任务需要处理，则需要的线程数为tasks/(1/taskTime)  = tasks*taskTime。假设系统每秒任务数为100~1000，处理每个任务0.1秒，即10-100个线程，则corePoolSize应该大于10，根据场景，具体定多少核心线程。

`workQueue长度`：队列的长度要根据核心线程数以及系统对任务的响应时间设置，corePoolSize核心线程数每秒处理任务数量：corePoolSize\*(1/taskTime) = corePoolSize/taskTime，再乘以响应时间(单位s)：corePoolSize/taskTime\*responseTime，为队列最大长度。如果队列过大，则响应时间过长，就会超时。

corePoolSize:10，taskTime: 0.1s，responseTime:2s  则系统每秒能处理100个任务，在响应时间内的最大任务长度为200.

`maxPoolSize`: 当任务达到最大长度后，系统无法核心线程无法完成所有任务，所以需要再创建线程，100个任务需要10个线程，则1000个任务（1000-workQueue）*(10/100) = 80，最大需要80个线程

（上面参数是在不考虑硬件资源的情况下）

