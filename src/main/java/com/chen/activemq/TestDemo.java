package com.chen.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jms.Destination;
public class TestDemo {

    @Autowired
    private Producer producer;

    public void test1(){
        Destination destination = new ActiveMQQueue("test.queque");
        for (int i = 0; i < 10; i++) {
          producer.send(destination,"HelloWorld");

        }

    }
}
