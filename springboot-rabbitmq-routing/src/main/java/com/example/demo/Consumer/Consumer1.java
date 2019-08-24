package com.example.demo.Consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = {@QueueBinding(
        value = @Queue(value = "routing1"),
        exchange = @Exchange(value = "luyou", type = ExchangeTypes.FANOUT),
        key = "news.send")})
public class Consumer1
{

    @RabbitHandler
    public void showMessage(String message)
    {
        System.out.println("Consumer1接收到消息：" + message);
    }

}
