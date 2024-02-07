package com.daixiaoyu.simpledemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-24 18:57
 **/
@Component
public class RunLinner implements CommandLineRunner {
    @Autowired
    private UserMessageProducer producer;

    @Override
    public void run(String... args) throws Exception {
        producer.sendMessage("今天不上班");
    }
}
