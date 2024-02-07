package com.daixiaoyu.simpledemo;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: advance
 * @author: water76016
 * @description: 消息配置参数
 * @version: v1.0.0
 * @create: 2023-09-24 16:46
 **/
@Configuration
public class UserMessageBean {
    //创建交换机
    @Bean
    public Exchange exchange(){
        /**
         * 定义交换器参数
         * 1.交换器名称
         * 2.开启持久化
         * 3.不自动删除。表示该交换器若没有queue绑定的话，是否会被自动删除
         */
        return new TopicExchange(DemoConstant.USER_EXCHANGE_NAME, true, false);
    }

    //创建队列
    @Bean
    public Queue queue() {
        /**
         * 创建队列参数
         * 1.队列的名称
         * 2.队列是否持久化
         * 3.定义是否排他式使用。这意味着仅对声明它的连接可见，对其他连接不可见
         * 4.是否自动删除。当这个队列没有被使用时，会被自动删除
         */
        return new Queue(DemoConstant.USER_QUEUE_NAME, true, false, false);
    }
    //将队列绑定到这个交换机上
    @Bean
    public Binding binding(Exchange exchange, Queue queue) {
        return BindingBuilder
                .bind(queue).to(exchange).with("*.orange.*")
                .noargs();
    }
}
