package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 测试手动提交事物
 * 开启事物若不提交，消息相当于没有消费，因为连接没断，会一直占用着此消息，也不会被其它消费者消费
 */
public class JMSConsumer5 {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK= ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL="tcp://192.168.94.151:61616";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session = null;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer5.USERNAME, JMSConsumer5.PASSWORK, JMSConsumer5.BROKERURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            //打开事物
            session = connection.createSession(Boolean.TRUE, Session.SESSION_TRANSACTED);
            destination = session.createQueue("Q-NUMBER");
            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(new JMSListener(session));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //连接不能关，关了就不监听了
        }
    }
}
