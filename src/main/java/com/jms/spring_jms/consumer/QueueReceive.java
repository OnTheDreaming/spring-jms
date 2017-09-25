package com.jms.spring_jms.consumer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class QueueReceive {


    public static void main(String[] args) {

        AbstractApplicationContext applicationContext=new ClassPathXmlApplicationContext("consumer.xml");
    }
}
