package com.example.demo.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class TestRabbitMQ
{

    @Autowired
    private HelloSender helloSender;

    @RequestMapping("testRabbit")
    public void testRabbit()
    {
        helloSender.send();
    }

}
