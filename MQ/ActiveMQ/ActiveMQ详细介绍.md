# ActiveMQ详细介绍

# 1. 简单示例

- 创建连接

```java
ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.94.151:61616");
Connection connection = connectionFactory.createConnection();
connection.start();
```

- 创建queue生产者，发送消息

  ```java
  session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
              destination = session.createQueue("Q-NUMBER");
              messageProducer = session.createProducer(destination);
              TextMessage textMessage = session.createTextMessage("ActiveMQ发送消息+eeee");
  messageProducer.send(textMessage);
  session.commit();
  ```

- 创建Topic生产者，发送消息

  ```java
   session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
              destination = session.createTopic("myFirstTopic");
              messageProducer = session.createProducer(destination);
              TextMessage textMessage = session.createTextMessage("ActimeMQ发送主题");
              System.out.println(textMessage.getText());
              messageProducer.send(textMessage);
  
              //提交
              session.commit();
  ```

- 创建队列消费者，阻塞模式

  ```java
  session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
  destination = session.createQueue("Q-NUMBER");
  messageConsumer = session.createConsumer(destination);
  
  while (true){
      TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
      if(textMessage!=null){
          System.out.println("收到消息："+textMessage.getText());
      }else {
          break;
      }
  }
  ```

- 创建队列消费者，监听模式（连接不要关了）

  ```java
  session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
  destination = session.createQueue("Q-NUMBER");
  messageConsumer = session.createConsumer(destination);
  messageConsumer.setMessageListener(new JMSListener());
  ```

  ```java
  public class JMSListener implements MessageListener {
      public void onMessage(Message message) {
          try {
              System.out.println("收到消息: "+((TextMessage)message).getText());
          } catch (JMSException e) {
              e.printStackTrace();
          }
      }
  }
  
  ```

- 创建主题消费者，阻塞模式

  ```java
  session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
  destination = session.createTopic("myFirstTopic");
  messageConsumer = session.createConsumer(destination);
  
  while (true){
      TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
      if(textMessage!=null){
          System.out.println("收到消息："+textMessage.getText());
      }else {
          break;
      }
  }
  ```

- 创建主题消费者，监听模式,JMSListener类与上面一样

  ```java
  session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
  destination = session.createTopic("myFirstTopic");
  messageConsumer = session.createConsumer(destination);
  messageConsumer.setMessageListener(new JMSListener());
  ```


## 2. 发送消息设置

发送消息要保证消息的可靠性，解决方案是在事物中发送持久性的消息。事物能保证程序出错时不会误发消息，持久性能保证消息没被消费的情况下，mq消息不会丢失。

### 2.1 事物

创建session的时候指定事物`session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);`，第二个参数可以忽略，当有事物时第二个参数默认为`Session.SESSION_TRANSACTED`。当执行`session.commit()`时，消息才真正发送提交，可以在一个事物里发送多条消息。回滚`session.rollback()`

### 2.2 持久化与非持久化

```java
public interface DeliveryMode {
    static final int NON_PERSISTENT = 1;

    static final int PERSISTENT = 2;
}
	
```

- 持久化后可以保证消息服务由于某种原因不会丢失消息（如：mq服务器重启）

- 使用messageProducer.setDeliveryMode方法，所有的消息都采用此传送模式

- 使用messageProducer.send方法为每一条消息设置传送模式

### 2.3 超时

- 使用messageProducer.setTimeToLive方法，所有的消息都采用此过期时间

- 使用messageProducer.send方法为每一条消息设置过期时间

### 2.4 设置优先级

消息传送者将会首先尝试传送优先级较高的消息。消息优先级有0-9十个级别，0-4是普通消息，5-9是加急消息，默认为4

- 使用messageProducer.setPriority方法，所有的消息都采用此优先级

- 使用messageProducer.send方法为每一条消息设置优先级

### 2.5 异步发送消息

- 使用Connection URI配置异步发送:

  `cf = new ActiveMQConnectionFactory("tcp://locahost:61616?jms.useAsyncSend=true");`

- 在ConnectionFactory层面配置异步发送:

  `((ActiveMQConnectionFactory)connectionFactory).setUseAsyncSend(true);`

- 在Connection层面配置异步发送，此层面的设置将覆盖ConnectionFactory层面的设置:

  `((ActiveMQConnection)connection).setUseAsyncSend(true);`

## 3. 接收消息设置

接受消息也要保证可靠性，在事物中接收消息。

### 3.1 控制消息签收（AcknowledgeMode）

客户端成功接收一条消息的标志是这条消息被签收，有如下三个阶段

 	1. 客户端接收消息
 	2. 客户端处理消息
 	3. 消息被签收（可以由客户端发起，也可以由ActiveMQ发起，取决于Session签收模式的设置）

- 在带事物的session中，签收发生在session.commit()时，如果事物发生了回滚，消息会再次被传送。

- 在不带事物的session中，签收取决于session的设置

  - Session.AUTO_ACKNOWLEDGE。当客户成功的从receive方法返回的时候，或者从MessageListener.onMessage方法成功返回的时候，会话自动确认客户收到的消息。
  - Session.CLIENT_ACKNOWLEDGE。 客户端通过消息的 acknowledge 方法确认消息。需要注意的是，在这种模式中，确认签收是在会话层上进行：确认一个被消费的消息将自动确认所有已被会话消费的消息。例如，如果一个消息消费者消费了 10 个消息，然后确认第 5 个消息，那么所有 10 个消息都被确认。
  - Session.DUPS_ACKNOWLEDGE。 该选择只是会话迟钝的确认消息的提交。如果 JMS provider 失败，那么可能会导致一些重复的消息。如果是重复的消息，那么 JMS provider 必须把消息头的 JMSRedelivered 字段设置为 true。
  - Session.SESSION_TRANSACTED：事务

  例如：

`session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);` 设置在事物中接收消息，第二个参数默认为Session.SESSION_TRANSACTED。当执行`session.commit()`时才认为消息消费成功



对一个队列来说，如果sessionz终止时，它接受了消息，但是没有签收，那么ActiveMQ会认为消息没有被消费成功，会再次传送给消费者

对主题来说，对与非持久订阅，session终止时会删除消息，对于持久订阅，已消费但未签收，会再次传送给消费者。

### 3.2 持久订阅

持久订阅可以增加消息的可靠性，客户端向ActiveMQ注册一个识别自己身份的ID，当这个客户端处于离线时，ActiveMQ会为这个ID保存所有发送到主题的消息，当客户端再次连接到ActiveMQ时，会得到离线这段时间发送的消息主题。

- 为连接设置一个客户ID
- 为订阅的主题指定一个订阅名称

```java
connection = connectionFactory.createConnection();
String clientId = "8fc38c5d-a4a9-43bb-b617-03f25cce2da5";
connection.setClientID(clientId);
connection.start();
session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
topic = session.createTopic("myFirstTopic");
TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "sub-durable-"+clientId);
durableSubscriber.setMessageListener(new JMSListener());
```

### 3.3 消费者异步分派

ActiveMQ可以以同步或者异步的模式向消费者分派消息。可以以异步模式向处理慢的消费者分派消息，以同步模式向处理消息快的消费者分派消息

- 在ConnectionFactory层面配置同步分派：`((ActiveMQConnectionFactory)connectionFactory).setDispatchAsync(false);`

- 在Connection层面配置同步分派，此层面的设置将覆盖ConnectionFactory层面的设置：

  `((ActiveMQConnection)connection).setDispatchAsync(false);`

- 在消费者层面以Destination URI配置同步分派，此层面的设置将覆盖ConnectionFactory和Connection层面的设置: 

  `queue = new ActiveMQQueue("TEST.QUEUE?consumer.dispatchAsync=false");  consumer = session.createConsumer(queue);`

### 3.4 消费者优先级

```java
queue = new ActiveMQQueue("TEST.QUEUE?consumer.prority=10");

consumer = session.createConsumer(queue);
```

### 3.5 独占的消费者

如果有多个消费者，那么同一时刻从队列中接收消息时就不能保证处理时是有序的，AMQ4支持独占的消费，会挑选一个consumer，并把队列中所有的消息按顺序分派给它。如果消费者发生故障，会选择另一个消费者。

```java
queue = new ActiveMQQueue("TEST.QUEUE?consumer.exclusive=true");

consumer = session.createConsumer(queue);
```

### 3.6 消息预取

预取限制来控制有多少消息能及时的传送给消费者，一旦达到预取数量，那就不会有消息被分派给这个消费者知道它发送签收消息。不是指同时处理的数量

如果有大量的消息并且希望高性能，可以为这个消费者增大预取值，如果有少量的消息并且花费时间都很长，可以设置预取值为1。这样同一时间AMQ只会为这个消费者分派一条消息

- 在ConnectionFactory层面为所有消费者配置预取值:

  `tcp://localhost:61616?jms.prefetchPolicy.all=50`

- 在ConnectionFactory层面为队列消费者配置预取值:

  `tcp://localhost:61616?jms.prefetchPolicy.queuePrefetch=1`

- 使用“目标选项”为一个消费者配置预取值: 

  `queue = new ActiveMQQueue("TEST.QUEUE?consumer.prefetchSize=10");`

  `consumer = session.createConsumer(queue);`

### 3.7 消息重试

```
//重发策略
RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
//是否采用碰撞因数做判断
queuePolicy.setUseCollisionAvoidance(false);
//碰撞躲避因数，会和重发延迟做计算，得出最终延迟时间,会在+-15%之间随机选择时间
queuePolicy.setCollisionAvoidancePercent((short) 15);
//重发延迟初始值
queuePolicy.setInitialRedeliveryDelay(1000);
//如果initialRedeliveryDelay为0则使用这个值
queuePolicy.setRedeliveryDelay(1000);
//是否成倍增加延迟
queuePolicy.setUseExponentialBackOff(false);
//成倍延迟倍率，上次延迟时间*此值为要计算时的延迟时间
queuePolicy.setBackOffMultiplier(5);
//UseCollisionAvoidance 为true时生效
queuePolicy.setMaximumRedeliveryDelay(200000);

//最大重发次数，从0开始
queuePolicy.setMaximumRedeliveries(2);

destination = session.createQueue("Q-NUMBER");

RedeliveryPolicyMap map = connection.getRedeliveryPolicyMap();
//为当前目的地设置重试策略
map.put((ActiveMQDestination) destination, queuePolicy);

```



**只会在当前消费者进行重试，不会切换到其他的消费者**