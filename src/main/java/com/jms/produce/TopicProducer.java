package com.jms.produce;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicProducer {
    private static  final String url="tcp://localhost:61616";//activeMQ地址
    private static  final String topicName="TOPIC_TEST";//队列名称
    private static ConnectionFactory connectionFactory;//连接工厂
    private static Connection connection;//连接
    private static Session session ;//连接会话
    private static Destination destination;//目的地
    private static MessageProducer producer;//消息提供者--生产者

    public static void main(String[] args) throws JMSException{

        try {
            //创建连接工厂
            connectionFactory=new ActiveMQConnectionFactory(url);
            //创建连接
            connection=connectionFactory.createConnection();
            //启动连接
            session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建主题(目的地)
            destination=session.createTopic(topicName);
            //创建生成者
            producer=session.createProducer(destination);
            for (int i = 0; i < 10; i++) {
                TextMessage message=session.createTextMessage("test" + i);
                producer.send(message);
                System.out.println("发送消息:"+message.getText());
            }
        }catch (JMSException e){
            e.printStackTrace();
        }finally {//关闭连接
            if (connection != null)
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
        }
    }
}

