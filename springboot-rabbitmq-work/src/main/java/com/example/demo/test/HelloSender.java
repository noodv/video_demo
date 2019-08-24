package com.example.demo.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender
{

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send()
    {
        amqpTemplate.convertAndSend("queue","hello,rabbit~");
    }

}
