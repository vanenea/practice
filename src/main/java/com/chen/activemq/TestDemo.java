package com.chen.activemq;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TestDemo {

    @Autowired
    private Producer producer;

    @Test
    public void test1(){
        Destination destination = new ActiveMQQueue("test.queque");
        for (int i = 0; i < 10; i++) {
          producer.send(destination,"HelloWorld");

        }

    }
}
