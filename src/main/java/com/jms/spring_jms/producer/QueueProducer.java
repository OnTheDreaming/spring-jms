package com.jms.spring_jms.producer;

import com.jms.services.SendDataServices;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class QueueProducer {

    private  static SendDataServices sendMessageImpl;

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("producer.xml");
        sendMessageImpl=(SendDataServices)  applicationContext.getBean("sendMessageImpl");
        for (int i = 0; i <10 ; i++) {
            sendMessageImpl.sendMessge("发送消息:" + i);
            System.out.println("发送消息:"+i);
        }
//        applicationContext.close();
    }
}
