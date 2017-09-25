package com.jms.services.servicesImpl;

import com.jms.services.ReciveDataServices;

public class ReceiveDataServiceImpl implements ReciveDataServices{
    @Override
    public void receiveData(String message) {//这里定义的接收对象类型需与发送的对象类型相匹配
             System.out.println("接收:"+message);

    }

}
