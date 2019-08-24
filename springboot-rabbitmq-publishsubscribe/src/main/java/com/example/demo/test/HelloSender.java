package com.example.demo.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSender
{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("sendmessage")
    public void send()
    {
        amqpTemplate.convertAndSend("exchangeQueue","","RabbitMQ:发布/订阅模式Publish/direct");
    }

}
