package com.daixiaoyu.simpledemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: advance
 * @author: water76016
 * @description: 消息生产者
 * @version: v1.0.0
 * @create: 2023-09-24 17:22
 **/
@Component
public class UserMessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(DemoConstant.USER_QUEUE_NAME, message);
        System.out.println("消息发送成功，发送的消息是：" + message);
    }
}
