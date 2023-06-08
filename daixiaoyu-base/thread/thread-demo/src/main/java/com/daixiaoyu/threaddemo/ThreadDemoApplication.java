package com.daixiaoyu.threaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadDemoApplication {

    public static void main(String[] args) {
        System.out.println("我正在执行");
        SpringApplication.run(ThreadDemoApplication.class, args);
    }

}
