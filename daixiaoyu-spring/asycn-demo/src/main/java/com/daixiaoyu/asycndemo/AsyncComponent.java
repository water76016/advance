package com.daixiaoyu.asycndemo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-08-27 22:37
 **/
@Component
public class AsyncComponent {
    @Async
    public void async(String str){
        System.out.println("输入的内容是" + str + "，异步任务正在休眠5秒..");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("休眠失败");
        }
        System.out.println("输入的内容是" + str + ",异步任务执行结束");
    }
}
