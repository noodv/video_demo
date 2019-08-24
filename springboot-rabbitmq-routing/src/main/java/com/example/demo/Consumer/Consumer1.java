package com.example.demo.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "testJD")
public class Consumer1
{

    @RabbitHandler
    public void showMessage(String message)
    {
        System.out.println("Consumer1接收到消息：" + message);
    }

}
