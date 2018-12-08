package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer {
    private static final String USERNAME = "admin"; //ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK = "admin"; // ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = "tcp://192.168.94.151:61616";
    //private static final String BROKERURL= ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENTNUM = 10;


    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session = null;
        Destination destination;
        MessageProducer messageProducer;

        System.out.println(BROKERURL);

        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORK, JMSProducer.BROKERURL);


        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("Q-NUMBER");
            messageProducer = session.createProducer(destination);
            sendMessage(session, messageProducer);

            //提交
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void sendMessage(Session session, MessageProducer messageProducer) throws Exception {
        for (int i = 0; i < JMSProducer.SENTNUM; i++) {
            TextMessage textMessage = session.createTextMessage("ActiveMQ发送消息+" + i);
            System.out.println(textMessage.getText());
            //设置过期时间，ms。默认消息永不过期
            messageProducer.setTimeToLive(24*60*60*1000);
            //设置是持久还是非持久消息,持久化后，若消费未被消费，mq服务器重启，消息不会丢失
            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
            messageProducer.send(textMessage);
        }

    }


}
