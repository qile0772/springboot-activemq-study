package com.qile.advisory.demo.service;

import org.apache.activemq.command.*;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
public class JmsConsumer {

    @JmsListener(destination = "ActiveMQ.Advisory.Producer.Topic.test.topic",containerFactory = "myJmsContainerFactory")
    public void receiveActiveProductTopic(Message msg){
        if (msg instanceof ActiveMQMessage) {
            ActiveMQMessage aMsg = (ActiveMQMessage) msg;
            ProducerInfo prod = (ProducerInfo) aMsg.getDataStructure();
            System.out.println("topic listen ok");
        } else {
            System.out.println("topic listen fail");
        }
    }

    @JmsListener(destination = "ActiveMQ.Advisory.Consumer.Topic.test.topic",containerFactory = "myJmsContainerFactory")
    public void receiveActiveConsumerTopic(Message msg){
        if (msg instanceof ActiveMQMessage) {
            ActiveMQMessage aMsg = (ActiveMQMessage) msg;

            DataStructure dataStructure = aMsg.getDataStructure();
            try {
                Integer count = aMsg.getIntProperty("consumerCount");
                System.out.println(count);
            } catch (JMSException e) {
                e.printStackTrace();
            }
            if (dataStructure instanceof ConsumerInfo){
                ConsumerInfo consumerInfo = (ConsumerInfo) dataStructure;
                System.out.println("topic consumer on");
            } else if (dataStructure instanceof RemoveInfo){
                RemoveInfo removeInfo = (RemoveInfo) dataStructure;
                System.out.println("topic consumer left");
            }

            System.out.println("topic listen ok");
        } else {
            System.out.println("topic listen fail");
        }
    }

    @JmsListener(destination = "ActiveMQ.Advisory.Producer.Queue.test.queue",containerFactory = "myJmsContainerFactory")
    public void receiveActiveProductQueue(Message msg){
        if (msg instanceof ActiveMQMessage) {
            ActiveMQMessage aMsg = (ActiveMQMessage) msg;
            ProducerInfo prod = (ProducerInfo) aMsg.getDataStructure();
            System.out.println("queue listen ok");
        } else {
            System.out.println("queue listen fail");
        }
    }

    @JmsListener(destination = "ActiveMQ.Advisory.Consumer.Queue.test.queue",containerFactory = "myJmsContainerFactory")
    public void receiveActiveConsumerQueue(Message msg){
        if (msg instanceof ActiveMQMessage) {
            ActiveMQMessage aMsg = (ActiveMQMessage) msg;
            DataStructure dataStructure = aMsg.getDataStructure();
            try {
                Integer count = aMsg.getIntProperty("consumerCount");
                System.out.println(count);
            } catch (JMSException e) {
                e.printStackTrace();
            }
            if (dataStructure instanceof ConsumerInfo){
                ConsumerInfo consumerInfo = (ConsumerInfo) dataStructure;
                System.out.println("queue consumer on");
            } else if (dataStructure instanceof RemoveInfo){
                RemoveInfo removeInfo = (RemoveInfo) dataStructure;
                System.out.println("queue consumer left");
            }

            System.out.println("queue listen ok");
        } else {
            System.out.println("queue listen fail");
        }
    }
}
