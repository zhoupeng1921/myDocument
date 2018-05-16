package com.xhx.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        String queueName = "Q_QUEUE_NAME";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.94.151");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queueName,false,false,false,null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(java.lang.String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String string = new String(body, "UTF-8");
                System.out.println("channel:"+channel+",queue:"+queueName+",consumer:"+this.getConsumerTag()+"  Received '" + string + "'");
//                channel.basicAck(envelope.getDeliveryTag(),false);
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                }
            }
        };

        channel.basicConsume(queueName,true,consumer);
    }
}
