package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.broker.region.policy.RedeliveryPolicyMap;
import org.apache.activemq.command.ActiveMQDestination;

import javax.jms.*;

/**
 * 消息重试 -- 都是在当前的session中进行重试，不会重试其它消费者
 */
public class JMSConsumer4 {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = "tcp://192.168.94.151:61616";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        ActiveMQConnection connection = null;
        Session session = null;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer4.USERNAME, JMSConsumer4.PASSWORK, JMSConsumer4.BROKERURL);

        try {
            connection = (ActiveMQConnection)connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

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


            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(new JMSListener());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
