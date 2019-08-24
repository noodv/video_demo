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
        amqpTemplate.convertAndSend("luyou","error.log","RabbitMQ:使用路由模式发送了消息：error.log");
    }

}
