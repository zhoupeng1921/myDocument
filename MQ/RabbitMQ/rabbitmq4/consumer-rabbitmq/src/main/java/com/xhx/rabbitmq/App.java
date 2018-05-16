package com.xhx.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String EXCHANGE_NAME="topic_exchange_name";
    private static String ROUTING_KEY="topic.#";
    public static void main( String[] args ) throws Exception
    {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.94.151");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.TOPIC,true);
        String queue = channel.queueDeclare("q_queue",true,false,false,null).getQueue();
        channel.queueBind(queue,EXCHANGE_NAME,ROUTING_KEY);

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException
            {
                System.out.println(new String(body,"utf-8"));
            }
        };
        channel.basicConsume(queue,true,consumer);
    }
}
