package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 测试手动提交事物
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

            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //连接不能关，关了就不监听了
        }
    }
}
