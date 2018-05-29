package com.chen.activemq;

import org.springframework.jms.annotation.JmsListener;

public class Consumer {


    @JmsListener(destination = "test.queque")
    public void receiverQueue(String text){
        System.out.println("text:"+text);
    }
}
