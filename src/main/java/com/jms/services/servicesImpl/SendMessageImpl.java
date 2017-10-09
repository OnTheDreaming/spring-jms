package com.jms.services.servicesImpl;

import com.jms.services.SendDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.io.Serializable;

public class SendMessageImpl implements SendDataServices {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessge(Destination destination,final Serializable obj) {
//        jmsTemplate.send(destination, new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                    TextMessage textMessage= session.createTextMessage(message);
//                    return textMessage;
//            }
//        });
        jmsTemplate.convertAndSend(destination,obj);
    }
}
