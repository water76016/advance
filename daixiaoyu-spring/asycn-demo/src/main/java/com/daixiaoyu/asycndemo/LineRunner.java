package com.daixiaoyu.asycndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-08-27 22:42
 **/
@Component
public class LineRunner implements CommandLineRunner {
    @Autowired
    private AsyncComponent asyncComponent;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("主线程开始");
        asyncComponent.async("今天不上班，好耶");
        System.out.println("主线程结束");
    }
}
