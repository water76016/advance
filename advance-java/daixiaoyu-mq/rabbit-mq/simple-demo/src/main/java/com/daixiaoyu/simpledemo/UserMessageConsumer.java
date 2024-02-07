package com.daixiaoyu.simpledemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description: 消息消费者
 * @version: v1.0.0
 * @create: 2023-09-24 16:20
 **/
@Component
public class UserMessageConsumer {
    @RabbitListener(queues = DemoConstant.USER_QUEUE_NAME)
    public void receiveMessage(String message){
        System.out.println("消息被接收，收到的消息是：" + message);
    }
}
