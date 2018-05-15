package com.xhx.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String EXCHANGE_NAME="EX_DIRECT";
    private static final String[] ROUTING_KEY= {"A","B","C"};

    public static void main( String[] args ) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("192.168.94.151");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();
        //指定binding key，绑定exchange与queueName
        // String bindingkey = getRoutingkey();
        String bindingkey = "A";
        System.out.println("bindingkey:"+bindingkey);
        channel.queueBind(queueName,EXCHANGE_NAME,bindingkey);


        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException
            {
                System.out.println("获得信息"+new String(body,"UTF-8"));
            }
        };

        channel.basicConsume(queueName,true,consumer);
    }

    private static String getRoutingkey(){
        Random random = new Random();
        int i = random.nextInt(3);
        return ROUTING_KEY[i];
    }
}
