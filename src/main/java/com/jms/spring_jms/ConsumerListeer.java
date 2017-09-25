package com.jms.spring_jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by caowenhui on 2017/9/23.
 */
public class ConsumerListeer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage)message;
        try {
            System.out.println("接收消息到的消息为:"+textMessage.getText());
        }catch ( JMSException e){
            e.printStackTrace();
        }
    }
}
