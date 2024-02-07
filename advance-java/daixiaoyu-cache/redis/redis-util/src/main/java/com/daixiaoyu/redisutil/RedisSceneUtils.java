package com.daixiaoyu.redisutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: redis-util
 * @author: water76016
 * @description: Redis场景工具类
 * @version: v1.0.0
 * @create: 2023-02-01 23:47
 **/
@Component
public class RedisSceneUtils {
    private static final int MULTI_SIZE = 500;

    private static StringRedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        RedisSceneUtils.redisTemplate = redisTemplate;
    }
    //是否开启大key扫描，默认不开启
    @Value("${redis.assist.bigkey.auto:false}")
    private String bigkeyAuto;
    //满足大key的阈值 ，默认是1M
    @Value("${redis.assist.bigkey.threshold:1024 * 1024}")
    private String bigkeyThreshold;
    //Redis大key的最大返回列表，默认1000
    @Value("${redis.assist.bigkey.count:1000}")
    private String bigkeyCount;
    /**
     * @author: water76016
     * @createTime: 2023年02月01 23:48:45
     * @description: 根据某个键前缀删除一部分键，返回删除键的数量
     * @param: perfix
     * @return: long
     */
    public static long delKeysByPerfix(String perfix){
        long result = 0;
        Cursor<String> cursor = redisTemplate.scan(ScanOptions.scanOptions().count(MULTI_SIZE).match(perfix + "*").build());
        List<String> keys = new ArrayList<>();
        while (cursor.hasNext()){
            String key = cursor.next();
            keys.add(key);
            if (keys.size() > MULTI_SIZE){
                result = result + RedisBaseUtils.delete(keys);
                keys.clear();
            }
        }
        //此时keys的列表里面可能还有一部分数据，还需要做一次清空
        result = result + RedisBaseUtils.delete(keys);
        return result;
    }
    /**
     * @author: water76016
     * @createTime: 2023年04月18 01:00:02
     * @description: 获取Redis里面的大key，返回key以及所占用的字节数
     * @param:
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Integer>>
     */
    public static List<Map<String, Integer>> getBigKeys(){
        return null;
    }
}
