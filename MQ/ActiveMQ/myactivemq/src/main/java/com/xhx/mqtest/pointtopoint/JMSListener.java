package com.xhx.mqtest.pointtopoint;


import javax.jms.*;
import java.util.Objects;

public class JMSListener implements MessageListener {
    private Session session;

    public JMSListener() {

    }

    public JMSListener(Session session) {
        this.session = session;
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("收到消息: " + ((TextMessage) message).getText());

            //测试消息重试时用的
        /*    if(true){
                throw new RuntimeException("测试失败");
            }*/

            //测试手动提交事物
            if (Objects.nonNull(session)) {
                session.commit();
            }
        } catch (JMSException e) {
            e.printStackTrace();
            try {
                if (Objects.nonNull(session)) {
                    session.rollback();
                }
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
        }
    }
}
