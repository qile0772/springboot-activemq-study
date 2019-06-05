package com.qile.mq.demo.controller;

import com.qile.mq.demo.serivce.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private Publisher publisher;

    @PostMapping("/send")
    public String send(@RequestBody String message){
        publisher.publish("test.topic",message);
        return "OK";
    }
}
