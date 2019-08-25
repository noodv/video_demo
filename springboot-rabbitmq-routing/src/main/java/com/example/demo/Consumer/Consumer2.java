package com.example.demo.Consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = {@QueueBinding(
        value = @Queue(value = "queue2"),
        exchange = @Exchange(value = "luyou", type = ExchangeTypes.DIRECT),
        key = "news.routing2")})
public class Consumer2
{

    @RabbitHandler
    public void showMessage(String message)
    {
        System.out.println("Consumer2接收到消息：" + message);
    }

}
