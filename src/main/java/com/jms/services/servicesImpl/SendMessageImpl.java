package com.jms.services.servicesImpl;

import com.jms.services.SendDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.*;

public class SendMessageImpl implements SendDataServices {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource(name = "topicDestination")
    private Destination destination;
    @Override
    public void sendMessge(final  String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                    TextMessage textMessage= session.createTextMessage(message);
                    return textMessage;
            }
        });
    }
}
