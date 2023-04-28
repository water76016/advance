package com.water76016.advance.event.listener.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-04-29 00:45
 **/
@Component
public class StartApplicationRunner implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public void run(String... args) throws Exception {
        EventMessage message = new EventMessage();
        message.setName("消息name");
        message.setDescription("消息description");
        EventDemo eventDemo = new EventDemo(message);
        applicationContext.publishEvent(eventDemo);
    }
}
