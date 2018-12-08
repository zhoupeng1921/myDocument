package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSConsumer {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK= ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL="tcp://192.168.94.151:61616";
    private static final int SENTNUM=10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session = null;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME,JMSConsumer.PASSWORK,JMSConsumer.BROKERURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
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



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
