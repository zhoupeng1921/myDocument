# JMS基本概念

## 介绍

JMS(java message service)是一个消息服务的规范。消息生产者和消费者是异步的，生产者只负责把消息发送到队列中，消费者有没有消费生产者其实是不知道的。可以用来做异步传输，减低分布式系统通信的耦合度。

有两种消息模型：

- Point-to-Point(P2P) 点对点模式
- Publish/Subscribe(Pub/Sub)发布订阅模式

## P2P

### 特点

1. 每个消息只能被一个消费者消费
2. 接收者接受之后，需要向队列做出应答
3. 无时间上的依赖性，生产者发送了消息，消费者再监听，也依旧能收到消息，队列保存着消息直到被消费或者超时。

### 概念

1. 消息队列（queue）
2. 消息生产者
3. 消息消费者

适用于希望每个消息都能够被成功处理的业务场景



## Pub/Sub

### 特点

1. 每个消息可以有多个消费者

2. 发布者和订阅者有时间上的依赖性，生产者先发布消息，消费者不处于监听状态会造成收不到消息。（可以通过创建持久化订阅者来解决此问题）

### 概念

1. 主题（topic）
2. 发布者（就是生产者）
3. 订阅者（就是消费者，因为可以有多个消费者，所以订阅这个词比较恰当）

 适用于可能存在多个消费者并且允许消息丢失的业务场景



## 两种消费模式

- 同步
  - receive   会处于阻塞状态

- 异步
  - 注册一个消息监听器，接收到消息后，会调用onMessage方法

## java中概念

1. `ConnectionFactory` 连接工厂,用来创建连接
   - QueueConnectionFactory
   - TopicConnectionFactory

2. `Connection`连接，用来创建会话
   - QueueConnection
   - TopicConnection

3. `Session` 会话，用来创建消费者、生产者、队列等，同时提供了事物的功能
   - QueueSession
   - TopicSession

4. `Destination`队列，生产者发送的目的地或者消费者的消息来源的地方
   - Queue
   - Topic

5. `MessageConsumer`消费者
   - QueueReceiver
   - TopicSubscriber

6. `MessageProducer`生产者
   - QueueSender
   - TopicPublisher

7. `MessageListener`消息监听器，不会阻塞