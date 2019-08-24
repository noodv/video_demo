package com.example.demo.Consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component //组件
public class Consumer2
{

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue2",autoDelete = "true"),
            exchange = @Exchange(value = "exchangeQueue",type = ExchangeTypes.FANOUT))
    )
    public void showMessage(String message)
    {
        System.out.println("Consumer2接收到消息：" + message);
    }

}