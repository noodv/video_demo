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
        amqpTemplate.convertAndSend("spring.topic.exchange", "person.insert", "增加人员");
        amqpTemplate.convertAndSend("spring.topic.exchange", "person.delete", "删除人员");
        amqpTemplate.convertAndSend("spring.topic.exchange", "money.insert", "加钱");
        amqpTemplate.convertAndSend("spring.topic.exchange", "money.delete", "减钱");
    }

}
