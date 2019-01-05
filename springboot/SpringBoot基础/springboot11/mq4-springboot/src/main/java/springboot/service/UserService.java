package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class UserService {
    @Autowired
    @Qualifier("jmsTopicMessagingTmeplate")
    private JmsMessagingTemplate jmsTopicMessagingTmeplate;

    @Autowired
    @Qualifier("jmsQueueMessagingTmeplate")
    private JmsMessagingTemplate jmsQueueMessagingTmeplate;

    @Autowired
    @Qualifier("myTopic")
    private Topic myTopic;

    @Autowired
    @Qualifier("myQueue")
    private Queue myQueue;


    @Transactional(propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
    public String add() {
        jmsQueueMessagingTmeplate.convertAndSend(myQueue,"userAdd-quqeu");

        jmsTopicMessagingTmeplate.convertAndSend(myTopic,"userAdd-topic");
        System.out.println(1/0);
        return "success";
    }
}
