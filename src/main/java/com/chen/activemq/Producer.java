package com.chen.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;


    public void send(Destination destination, final String message){

        jmsTemplate.convertAndSend(destination,message);
    }

}
