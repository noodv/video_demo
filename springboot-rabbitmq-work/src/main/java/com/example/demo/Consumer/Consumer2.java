package com.example.demo.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component //组件
public class Consumer2
{

    @RabbitHandler
    @RabbitListener(queues = "testJD")
    public void showMessage(String message)
    {
        System.out.println("Consumer2接收到消息：" + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "testJD")
    public void showMessage3(String message)
    {
        System.out.println("Consumer3接收到消息：" + message);
    }

}