package com.xhx.rabbitmq;

import com.xhx.rabbitmq.entity.MessageInfo;
import com.xhx.rabbitmq.publish.PublisherHandler;
import com.xhx.rabbitmq.receive.ReceiverHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        PublisherHandler publisherHandler = null;
        ReceiverHandler receiverHandler = null;

        receiverHandler = new ReceiverHandler("Q_MESSAGEINFO");
        Thread receiveThread = new Thread(receiverHandler);
        receiveThread.start();


        publisherHandler = new PublisherHandler("");
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setChannel("channel");
        messageInfo.setContent("content");
        publisherHandler.sendMessage(messageInfo);

        /**
         * 1338203482，等待消息中...
         * --------result:amq.ctag-eYEt2qo0YYYjNPJENAJ5DQ
         * --------result:amq.ctag-R3V0fYpNg_CylBTSwgI3NQ
         * channel:AMQChannel(amqp://admin@192.168.94.151:5672/,1),queue:Q_MESSAGEINFO1,consumer:amq.ctag-R3V0fYpNg_CylBTSwgI3NQ  Received 'MessageInfo{channel='channel', content='content', hashCode=0}'
         * channel:AMQChannel(amqp://admin@192.168.94.151:5672/,1),queue:Q_MESSAGEINFO1,consumer:amq.ctag-R3V0fYpNg_CylBTSwgI3NQ  Received 'MessageInfo{channel='channel', content='content', hashCode=0}'
         */

    }
}
