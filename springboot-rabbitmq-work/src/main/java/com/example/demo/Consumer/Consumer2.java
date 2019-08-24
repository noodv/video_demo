package com.example.demo.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component //组件
@RabbitListener(queues = "testJD")
public class Consumer2
{

    @RabbitHandler
    public void showMessage(String message)
    {
        System.out.println("Consumer2接收到消息：" + message);
    }

}