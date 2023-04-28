package com.water76016.advance.event.listener.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-04-29 00:10
 **/
@Component
public class ListenerDemo1 implements ApplicationListener<EventDemo> {
    @Override
    public void onApplicationEvent(EventDemo event) {
        System.out.println("我是监听器1，收到事件消息：" + event.toString());
    }
}
