package com.qile.mq.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
public class WebConfiguration {

    @Bean
    public JmsListenerContainerFactory myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory simpleJmsListenerContainerFactory = new SimpleJmsListenerContainerFactory();
        simpleJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleJmsListenerContainerFactory.setPubSubDomain(true);
        return simpleJmsListenerContainerFactory;
    }

    @Bean
    public JmsListenerContainerFactory queueJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory simpleJmsListenerContainerFactory = new SimpleJmsListenerContainerFactory();
        simpleJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleJmsListenerContainerFactory.setPubSubDomain(false);
        return simpleJmsListenerContainerFactory;
    }
}
