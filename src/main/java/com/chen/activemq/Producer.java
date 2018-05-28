package com.chen.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;


    public void send(){

    }

}
