package com.daixiaoyu.redisutil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
class RedisBaseUtilsTest {
    private final String PERFIX = "redis-util";
    private final String STRING_PERFIX = "STRING_" + PERFIX + ":";
    private final String HASH_PERFIX = "HASH_" + PERFIX + ":";
    private final String LIST_PERFIX = "LIST_" + PERFIX + ":";
    private final String SET_PERFIX = "SET_" + PERFIX + ":";
    private final String ZSET_PERFIX = "ZSET_" + PERFIX + ":";

    /**
     * @author: water76016
     * @createTime: 2023年02月04 01:14:01
     * @description: 执行测试用例之前，先清空Redis中所有的测试数据
     * @param:
     * @return: void
     */
    @BeforeEach
    void initTestData(){
        RedisSceneUtils.delKeysByPerfix(STRING_PERFIX);
        RedisSceneUtils.delKeysByPerfix(HASH_PERFIX);
        RedisSceneUtils.delKeysByPerfix(LIST_PERFIX);
        RedisSceneUtils.delKeysByPerfix(SET_PERFIX);
        RedisSceneUtils.delKeysByPerfix(ZSET_PERFIX);
    }

    @Test
    void keys() {
    }

    @Test
    void hasKey() {
    }

    @Test
    void delete() {
    }

    @Test
    void persist() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void expire() {
    }

    @Test
    void getExpire() {
    }

    @Test
    void set() {
        RedisBaseUtils.set(STRING_PERFIX + "temp", "temp");
        String str = RedisBaseUtils.get(STRING_PERFIX + "temp");
        assertEquals("temp", str);
    }

    @Test
    void get() {
        RedisBaseUtils.set(STRING_PERFIX + "temp", "temp");
        String str = RedisBaseUtils.get(STRING_PERFIX + "temp");
        assertEquals("temp", str);
    }

    @Test
    void getAndSet() {
        RedisBaseUtils.set(STRING_PERFIX + "temp", "temp");
        String str = RedisBaseUtils.getAndSet(STRING_PERFIX + "temp", "temp2");
        assertEquals("temp", str);
        str = RedisBaseUtils.get(STRING_PERFIX + "temp");
        assertEquals("temp2", str);
    }

    @Test
    void multiSet() {
        Map<String, String> map = new HashMap<>();
        map.put(STRING_PERFIX + "one", "one");
        map.put(STRING_PERFIX + "two", "two");
        RedisBaseUtils.multiSet(map);
        String one = RedisBaseUtils.get(STRING_PERFIX + "one");
        String two = RedisBaseUtils.get(STRING_PERFIX + "two");
        assertEquals("one", one);
        assertEquals("two", two);
    }

    @Test
    void multiGet() {
        Map<String, String> map = new HashMap<>();
        map.put(STRING_PERFIX + "one", "one");
        map.put(STRING_PERFIX + "two", "two");
        RedisBaseUtils.multiSet(map);
        List<String> keys = new ArrayList<>();
        keys.add(STRING_PERFIX + "one");
        keys.add(STRING_PERFIX + "two");
        List<String> list = RedisBaseUtils.multiGet(keys);
        assertEquals(2, list.size());
    }

    @Test
    void setIfAbsent() {
        boolean flag = RedisBaseUtils.setIfAbsent(STRING_PERFIX + "temp", "temp");
        assertTrue(flag);
        flag = RedisBaseUtils.setIfAbsent(STRING_PERFIX + "temp", "temp2");
        assertFalse(flag);
        String str = RedisBaseUtils.get(STRING_PERFIX + "temp");
        assertEquals("temp", str);
    }

    @Test
    void increment() {
        String key = STRING_PERFIX + "one";
        RedisBaseUtils.set(key, String.valueOf(1));
        RedisBaseUtils.increment(key, 1);
        String str = RedisBaseUtils.get(key);
        assertEquals("2", str);
    }

    @Test
    void hput() {
        RedisBaseUtils.hput(HASH_PERFIX, "one", "one");
        String str = (String) RedisBaseUtils.hGet(HASH_PERFIX, "one");
        assertEquals("one", str);
    }

    @Test
    void hPutIfAbsent() {
        RedisBaseUtils.hPutIfAbsent(HASH_PERFIX, "one", "one");
        Object str = RedisBaseUtils.hGet(HASH_PERFIX, "one");
        assertEquals("one", str);
        RedisBaseUtils.hPutIfAbsent(HASH_PERFIX, "one", "two");
        str = RedisBaseUtils.hGet(HASH_PERFIX, "one");
        assertEquals("one", str);
        RedisBaseUtils.hPutIfAbsent(HASH_PERFIX, "two", "two");
        str = RedisBaseUtils.hGet(HASH_PERFIX, "two");
        assertEquals("two", str);
    }

    @Test
    void hputAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("one", "one");
        map.put("two", "two");
        RedisBaseUtils.hputAll(HASH_PERFIX, map);
        String str = (String) RedisBaseUtils.hGet(HASH_PERFIX, "one");
        assertEquals("one", str);
        str = (String) RedisBaseUtils.hGet(HASH_PERFIX, "two");
        assertEquals("two", str);
    }

    @Test
    void hGet() {
        RedisBaseUtils.hput(HASH_PERFIX, "one", "one");
        String str = (String) RedisBaseUtils.hGet(HASH_PERFIX, "one");
        assertEquals("one", str);
    }

    @Test
    void hGetAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("one", "one");
        map.put("two", "two");
        RedisBaseUtils.hputAll(HASH_PERFIX, map);
        List<Object> fields = new ArrayList<>();
        fields.add("one");
        fields.add("two");
        List<Object> values = RedisBaseUtils.hGetAll(HASH_PERFIX, fields);
        assertEquals(2, values.size());
    }

    @Test
    void hValues() {
        RedisBaseUtils.hput(HASH_PERFIX, "one", "one");
        RedisBaseUtils.hput(HASH_PERFIX, "two", "two");
        List<Object> values = RedisBaseUtils.hValues(HASH_PERFIX);
        assertEquals(2, values.size());
    }

    @Test
    void hDelete() {
        RedisBaseUtils.hput(HASH_PERFIX, "one", "one");
        RedisBaseUtils.hDelete(HASH_PERFIX, "one");
        boolean hasKey = RedisBaseUtils.hHasKey(HASH_PERFIX, "one");
        assertFalse(hasKey);
    }

    @Test
    void hHasKey() {
        RedisBaseUtils.hput(HASH_PERFIX, "one", "one");
        boolean hasKey = RedisBaseUtils.hHasKey(HASH_PERFIX, "one");
        assertTrue(hasKey);
        RedisBaseUtils.hDelete(HASH_PERFIX, "one");
        hasKey = RedisBaseUtils.hHasKey(HASH_PERFIX, "one");
        assertFalse(hasKey);
    }

    @Test
    void hKeys() {
        RedisBaseUtils.hput(HASH_PERFIX, "one", "one");
        RedisBaseUtils.hput(HASH_PERFIX, "two", "two");
        Set<Object> keys = RedisBaseUtils.hKeys(HASH_PERFIX);
        assertEquals(2, keys.size());
    }

    @Test
    void hSize() {
        RedisBaseUtils.hput(HASH_PERFIX, "one", "one");
        RedisBaseUtils.hput(HASH_PERFIX, "two", "two");
        long size = RedisBaseUtils.hSize(HASH_PERFIX);
        assertEquals(2, size);
    }

    @Test
    void lIndex() {
        RedisBaseUtils.lLeftPushAll(LIST_PERFIX, "one", "two", "three");
        Object two = RedisBaseUtils.lIndex(LIST_PERFIX, 1);
        assertEquals("two", two);
    }

    @Test
    void lRange() {
        RedisBaseUtils.lLeftPushAll(LIST_PERFIX, "one", "two", "three");
        List<String> list = RedisBaseUtils.lRange(LIST_PERFIX, 0,1);
        assertEquals("one", list.indexOf(0));
        assertEquals("two", list.indexOf(1));

    }

    @Test
    void lrightPushAll() {
        RedisBaseUtils.lrightPushAll(LIST_PERFIX, "one", "two");
        Object one = RedisBaseUtils.lLeftPop(LIST_PERFIX);
        assertEquals("one", one);
        Object two = RedisBaseUtils.lLeftPop(LIST_PERFIX);
        assertEquals("two", two);
    }
    @Test
    void lLeftPush() {
        RedisBaseUtils.lLeftPush(LIST_PERFIX, "one");
        RedisBaseUtils.lLeftPush(LIST_PERFIX, "two");
        Object two = RedisBaseUtils.lLeftPop(LIST_PERFIX);
        assertEquals("two", two);
    }

    @Test
    void lLeftPushAll() {
        RedisBaseUtils.lLeftPushAll(LIST_PERFIX, "one", "two");
        Object one = RedisBaseUtils.lrightPop(LIST_PERFIX);
        assertEquals("one", one);
        Object two = RedisBaseUtils.lrightPop(LIST_PERFIX);
        assertEquals("two", two);
    }

    @Test
    void lrightPush() {
        RedisBaseUtils.lrightPush(LIST_PERFIX, "one");
        RedisBaseUtils.lrightPush(LIST_PERFIX, "two");
        Object str = RedisBaseUtils.lLeftPop(LIST_PERFIX);
        assertEquals("one", str);
    }

    @Test
    void lLeftPop() {
        RedisBaseUtils.lLeftPushAll(LIST_PERFIX, "one", "two");
        Object object = RedisBaseUtils.lLeftPop(LIST_PERFIX);
        assertEquals("two", object);
    }

    @Test
    void lrightPop() {
        RedisBaseUtils.lLeftPushAll(LIST_PERFIX, "one", "two");
        Object object = RedisBaseUtils.lrightPop(LIST_PERFIX);
        assertEquals("one", object);
    }

    @Test
    void lSize() {
        RedisBaseUtils.lLeftPushAll(LIST_PERFIX, "one", "two");
        long size = RedisBaseUtils.lSize(LIST_PERFIX);
        assertEquals(2, size);
    }

    @Test
    void sRemove() {
    }

    @Test
    void sPop() {
    }

    @Test
    void testSPop() {
    }

    @Test
    void sIntersect() {
    }

    @Test
    void sSize() {
    }

    @Test
    void sAdd() {
    }

    @Test
    void sIsMember() {
    }

    @Test
    void testSIntersect() {
    }

    @Test
    void testSIntersect1() {
    }

    @Test
    void sUnion() {
    }

    @Test
    void testSUnion() {
    }

    @Test
    void sUnionAndStore() {
    }

    @Test
    void testSUnionAndStore() {
    }

    @Test
    void sDifference() {
    }

    @Test
    void testSUnion1() {
    }

    @Test
    void testSDifference() {
    }

    @Test
    void sDifferenceAndStore() {
    }

    @Test
    void testSDifferenceAndStore() {
    }

    @Test
    void sMembers() {
    }

    @Test
    void sRandomMembers() {
    }

    @Test
    void testSRandomMembers() {
    }

    @Test
    void zAdd() {
    }

    @Test
    void testZAdd() {
    }

    @Test
    void zRangeByScore() {
    }

    @Test
    void zRemove() {
    }

    @Test
    void zRank() {
    }

    @Test
    void zReverseRank() {
    }

    @Test
    void zRangeWithScores() {
    }

    @Test
    void zCount() {
    }

    @Test
    void zRangeByScoreWithScores() {
    }

    @Test
    void testZRangeByScoreWithScores() {
    }

    @Test
    void zIncrementScore() {
    }

    @Test
    void zReverseRangeByScoreWithScores() {
    }

    @Test
    void zReverseRangeByScore() {
    }

    @Test
    void zRange() {
    }

    @Test
    void testZReverseRangeByScore() {
    }

    @Test
    void zSize() {
    }

    @Test
    void zZCard() {
    }

    @Test
    void zScore() {
    }
}