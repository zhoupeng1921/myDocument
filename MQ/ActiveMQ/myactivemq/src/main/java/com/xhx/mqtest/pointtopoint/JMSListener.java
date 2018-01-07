package com.xhx.mqtest.pointtopoint;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JMSListener implements MessageListener {
    public void onMessage(Message message) {
        try {
            System.out.println("收到消息: "+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
