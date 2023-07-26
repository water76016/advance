package com.daixiaoyu.bloom;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: advance
 * @author: water76016
 * @description: 布隆过滤器的配置类
 * @version: v1.0.0
 * @create: 2023-07-26 23:59
 **/
@Configuration
public class BloomConfig {
    @Autowired
    private RedissonClient redissonClient;

    @Bean
    public RBloomFilter<String>  bloomFilter(){
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("bloomTest");
        bloomFilter.tryInit(100000L, 0.003);
        return bloomFilter;
    }
}
