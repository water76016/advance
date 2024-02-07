package com.daixiaoyu.redisutil;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RedisSceneUtilsTest {
    private final String PERFIX = "redis-util";
    private final String STRING_PERFIX = PERFIX + "-string";
    private final String HASH_PERFIX = PERFIX + "-hash";
    private final String LIST_PERFIX = PERFIX + "-list";
    private final String SET_PERFIX = PERFIX + "-set";
    private final String ZSET_PERFIX = PERFIX + "-zset";

    @Test
    void delKeysByPerfix() {
        RedisBaseUtils.set(STRING_PERFIX + "one", "one");
        RedisBaseUtils.set(STRING_PERFIX + "two", "two");
        RedisBaseUtils.set(STRING_PERFIX + "three", "three");
        RedisBaseUtils.set(STRING_PERFIX + "four", "four");
        RedisBaseUtils.set(STRING_PERFIX + "five", "five");
        Set<String> keys = RedisBaseUtils.keys(STRING_PERFIX + "*");
        assertEquals(5, keys.size());
        long count = RedisSceneUtils.delKeysByPerfix(STRING_PERFIX);
        assertEquals(5,count);
        keys = RedisBaseUtils.keys(STRING_PERFIX + "*");
        assertEquals(0, keys.size());
    }
}