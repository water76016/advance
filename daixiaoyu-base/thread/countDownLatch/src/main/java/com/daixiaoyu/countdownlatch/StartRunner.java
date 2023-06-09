package com.daixiaoyu.countdownlatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-10 00:21
 **/
@Component
public class StartRunner implements CommandLineRunner {
    CountDownLatch latch = new CountDownLatch(4);
    @Override
    public void run(String... args) throws Exception {
        System.out.println("选手开始登山");
        for (int i = 0; i < 4; i++){
            final int a = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //登山需要花费3秒，因此休眠3秒
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println(a + "号选手成功登山");
                        latch.countDown();
                        latch.await();
                        System.out.println(a + "号选手成功下山");
                    }
                    catch (Exception e){
                        System.out.println(a + "号选手登山失败");
                    }
                }
            });
            thread.start();
        }
    }
}
