package com.daixiaoyu.asycndemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @program: advance
 * @author: water76016
 * @description: 自定义Async的线程池
 * @version: v1.0.0
 * @create: 2023-09-12 00:59
 **/
@Configuration
public class ExecutorsAsyncConfig {
    @Bean(name = "asyncConfig")
    public Executor asyncConfig(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(5);
        //设置最大线程数
        executor.setMaxPoolSize(50);
        //设置缓存的队列
        executor.setQueueCapacity(1000);
        //设置空闲线程的超时时间
        executor.setKeepAliveSeconds(1000 * 5);
        //设置线程名称的前缀
        executor.setThreadNamePrefix("async-config-");
        executor.initialize();
        return executor;
    }
}
