package com.daixiaoyu.bloom;

import org.redisson.api.RBloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description: 验证布隆过滤器的使用
 * @version: v1.0.0
 * @create: 2023-07-26 01:36
 **/
@Component
public class LineRunner implements CommandLineRunner {
    @Autowired
    private RBloomFilter<String> bloomFilter;

    @Override
    public void run(String... args) throws Exception {
        String name1 = "小明";
        String name2 = "小张";
        bloomFilter.add(name1);
        bloomFilter.add(name2);
        boolean flag1 = bloomFilter.contains("小明");
        System.out.println("布隆过滤器中是否可能有小明？" + flag1);

        boolean flag2 = bloomFilter.contains("小李");
        System.out.println("布隆过滤器中是否可能有小李？" + flag2);
    }
}
