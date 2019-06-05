package com.qile.mq.demo.serivce;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class JmsConsumer {

    @JmsListener(destination = "test.topic",containerFactory = "myJmsContainerFactory")
    public void receiveTopic(String message){
        System.out.println(message);
    }

    @JmsListener(destination = "test.queue",containerFactory = "queueJmsContainerFactory")
    public void receiveQueue(String message){
        System.out.println(message);
    }

}
