package com.water76016.advance.event.listener.demo;

import org.springframework.context.ApplicationEvent;

/**
 * @program: advance
 * @author: water76016
 * @description: 监听器1
 * @version: v1.0.0
 * @create: 2023-04-29 00:04
 **/
public class EventDemo extends ApplicationEvent {
    public EventDemo(EventMessage source) {
        super(source);
    }
}
