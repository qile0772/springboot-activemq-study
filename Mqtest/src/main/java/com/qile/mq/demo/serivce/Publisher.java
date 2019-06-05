package com.qile.mq.demo.serivce;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;


@Service
public class Publisher {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void publish(String destinationName,String message){
        Destination destination = new ActiveMQTopic(destinationName);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
