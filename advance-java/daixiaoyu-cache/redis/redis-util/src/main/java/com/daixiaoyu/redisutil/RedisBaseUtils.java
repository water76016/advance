package com.daixiaoyu.redisutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: redis-util
 * @author: water76016
 * @description: Redis基础工具类
 * @version: v1.0.0
 * @create: 2023-02-01 23:47
 **/
@Component
public class RedisBaseUtils {
    private static StringRedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        RedisBaseUtils.redisTemplate = redisTemplate;
    }
    //***************************************key相关********************************
    /**
     * @author: water76016
     * @createTime: 2022年10月18 23:36:01
     * @description: 根据模糊匹配，获取键的集合
     * @param: pattern
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月18 23:36:18
     * @description: 判断键是否存在
     * @param: key
     * @return: java.lang.Boolean
     */
    public static Boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月18 23:36:31
     * @description: 删除单个键
     * @param: key
     * @return: java.lang.Boolean
     */
    public static Boolean delete(String key){
        return redisTemplate.delete(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月18 23:37:18
     * @description: 移除key的过期时间，key将不会过期
     * @param: key
     * @return: java.lang.Boolean
     */
    public static Boolean persist(String key){
        return redisTemplate.persist(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月18 23:36:41
     * @description: 批量删除多个键
     * @param: keys
     * @return: java.lang.Long
     */
    public static Long delete(Collection<String> keys){
        return redisTemplate.delete(keys);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月18 23:36:51
     * @description: 设置键的过期时间
     * @param: key
     * @param: timeout
     * @param: timeUnit
     * @return: java.lang.Boolean
     */
    public static Boolean expire(String key, long timeout, TimeUnit timeUnit){
        return redisTemplate.expire(key, timeout, timeUnit);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月18 23:37:28
     * @description: 返回key的剩余过期时间
     * @param: key
     * @return: java.lang.Long
     */
    public static Long getExpire(String key){
        return redisTemplate.getExpire(key);
    }

    /*********************************String相关操作**********************/
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:21:05
     * @description: 设置key的值为value
     * @param: key
     * @param: value
     * @return: void
     */
    public static void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:21:05
     * @description: 设置key的值为value
     * @param: key
     * @param: value
     * @return: void
     */
    public static void set(String key, int value){
        redisTemplate.opsForValue().set(key, String.valueOf(value));
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:25:09
     * @description: 获取key的值
     * @param: key
     * @return: java.lang.Object
     */
    public static String get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:26:08
     * @description: 获取旧的值，并设置新的值
     * @param: key
     * @param: value
     * @return: java.lang.Object
     */
    public static String getAndSet(String key, String value){
        return redisTemplate.opsForValue().getAndSet(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:29:58
     * @description: 批量添加值
     * @param: maps
     * @return: void
     */
    public static void multiSet(Map<String, String> maps){
        redisTemplate.opsForValue().multiSet(maps);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:27:33
     * @description: 批量获取值
     * @param: keys
     * @return: java.util.List<java.lang.String>
     */
    public static List<String> multiGet(Collection<String> keys){
        return redisTemplate.opsForValue().multiGet(keys);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:28:32
     * @description: 只有当key不存在时，才设置值（用于插入）
     * @param: key
     * @param: value
     * @return: boolean
     */
    public static boolean setIfAbsent(String key, String value){
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月19 23:32:15
     * @description: 将key的值自增increment个数量。若increment为负数，则为自减
     * @param: key
     * @param: increment
     * @return: java.lang.Long
     */
    public static Long increment(String key, long increment){
        return redisTemplate.opsForValue().increment(key);
    }

    /**************************Hash相关********************************/
    /**
     * @author: water76016
     * @createTime: 2022年10月22 22:47:14
     * @description: 向hash中添加值
     * @param: key
     * @param: field
     * @param: value
     * @return: void
     */
    public static void hput(String key, String field, Object value){
        redisTemplate.opsForHash().put(key, field, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 23:02:30
     * @description: 仅当hash中不存在该值时才设置成功。
     * @param: key
     * @param: field
     * @param: value
     * @return: java.lang.Boolean
     */
    public static Boolean hPutIfAbsent(String key, String field, Object value){
        return redisTemplate.opsForHash().putIfAbsent(key, field, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 22:56:58
     * @description: 批量往Redis中添加值
     * @param: key
     * @param: map
     * @return: void
     */
    public static void hputAll(String key, Map<String, Object> map){
        redisTemplate.opsForHash().putAll(key, map);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 22:58:26
     * @description: 获取hash中的值
     * @param: key
     * @param: field
     * @return: java.lang.Object
     */
    public static Object hGet(String key, String field){
        return redisTemplate.opsForHash().get(key, field);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 22:59:56
     * @description: 批量获取hash中的值
     * @param: key
     * @param: fieldList
     * @return: java.util.List<java.lang.Object>
     */
    public static List<Object> hGetAll(String key, List<Object> fieldList){
        return redisTemplate.opsForHash().multiGet(key, fieldList);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 23:19:06
     * @description: 获取某个哈希中所有的值
     * @param: key
     * @return: java.util.List<java.lang.Object>
     */
    public static List<Object> hValues(String key){
        return redisTemplate.opsForHash().values(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 23:04:53
     * @description: 删除一个或多个hash中的field，返回删除成功的field的数量
     * @param: key
     * @param: fields
     * @return: java.lang.Long
     */
    public static Long hDelete(String key, String ... fields){
        return redisTemplate.opsForHash().delete(key, fields);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 23:06:44
     * @description: 判断hash中是否有某个field
     * @param: key
     * @param: field
     * @return: java.lang.Boolean
     */
    public static Boolean hHasKey(String key, String field){
        return redisTemplate.opsForHash().hasKey(key, field);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 23:15:33
     * @description: 获取某个哈希中的所有字段
     * @param: key
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<Object> hKeys(String key){
        return redisTemplate.opsForHash().keys(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月22 23:17:24
     * @description: 获取某个哈希中字段的数量
     * @param: key
     * @return: java.lang.Long
     */
    public static Long hSize(String key){
        return redisTemplate.opsForHash().size(key);
    }

    /*********************List相关方法**************/
    /**
     * @author: water76016
     * @createTime: 2022年10月23 23:58:22
     * @description: 通过索引获取Redis中的元素
     * @param: key
     * @param: index
     * @return: java.lang.Object
     */
    public static Object lIndex(String key, long index){
        return redisTemplate.opsForList().index(key, index);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月23 23:59:40
     * @description: 获取指定范围内的List的元素
     * @param: key
     * @param: start
     * @param: end
     * @return: java.util.List<java.lang.String>
     */
    public static List<String> lRange(String key, long start, long end){
        return redisTemplate.opsForList().range(key, start, end);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:05:43
     * @description: 从List的尾部一次性插入多个元素
     * @param: key
     * @param: values
     * @return: java.lang.Long
     */
    public static Long lrightPushAll(String key, Collection<String> values){
        return redisTemplate.opsForList().rightPushAll(key, values);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:01:30
     * @description: 从List的头部插入元素
     * @param: key
     * @param: value
     * @return: java.lang.Long
     */
    public static Long lLeftPush(String key, String value){
        return redisTemplate.opsForList().leftPush(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:03:54
     * @description: 从List的头部一次性插入多个元素
     * @param: key
     * @param: values
     * @return: java.lang.Long
     */
    public static Long lLeftPushAll(String key, String ... values){
        return redisTemplate.opsForList().leftPushAll(key, values);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:05:43
     * @description: 从List的头部一次性插入多个元素
     * @param: key
     * @param: values
     * @return: java.lang.Long
     */
    public static Long lLeftPushAll(String key, Collection<String> values){
        return redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:01:30
     * @description: 从List的尾部插入元素
     * @param: key
     * @param: value
     * @return: java.lang.Long
     */
    public static Long lrightPush(String key, String value){
        return redisTemplate.opsForList().rightPush(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:03:54
     * @description: 从List的尾部一次性插入多个元素
     * @param: key
     * @param: values
     * @return: java.lang.Long
     */
    public static Long lrightPushAll(String key, String ... values){
        return redisTemplate.opsForList().rightPushAll(key, values);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:10:30
     * @description: 从列表的头部弹出并删除一个元素
     * @param: key
     * @return: java.lang.Object
     */
    public static Object lLeftPop(String key){
        return redisTemplate.opsForList().leftPop(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:12:56
     * @description: 从列表的头部弹出并删除一个元素，若元素没有，则阻塞等待一定时间。
     * @param: key
     * @param: timeout
     * @param: timeUnit
     * @return: java.lang.Object
     */
    public static Object lLeftPop(String key, long timeout, TimeUnit timeUnit){
        return redisTemplate.opsForList().leftPop(key, timeout, timeUnit);
    }

    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:10:30
     * @description: 从列表的尾部弹出并删除一个元素
     * @param: key
     * @return: java.lang.Object
     */
    public static Object lrightPop(String key){
        return redisTemplate.opsForList().rightPop(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:12:56
     * @description: 从列表的尾部弹出并删除一个元素，若元素没有，则阻塞等待一定时间。
     * @param: key
     * @param: timeout
     * @param: timeUnit
     * @return: java.lang.Object
     */
    public static Object lrightPop(String key, long timeout, TimeUnit timeUnit){
        return redisTemplate.opsForList().rightPop(key, timeout, timeUnit);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:21:42
     * @description: 获取列表的长度
     * @param: key
     * @return: java.lang.Long
     */
    public static Long lSize(String key){
        return redisTemplate.opsForList().size(key);
    }

    /*****************Set相关操作**********************/
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:40:44
     * @description: 移除集合中的元素
     * @param: key
     * @param: values
     * @return: java.lang.Long
     */
    public static Long sRemove(String key, Object values){
        return redisTemplate.opsForSet().remove(key, values);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:41:50
     * @description: 随机弹出集合中的某个元素
     * @param: key
     * @return: java.lang.Object
     */
    public static Object sPop(String key){
        return redisTemplate.opsForSet().pop(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:42:55
     * @description: 随机弹出集合中的多个元素
     * @param: key
     * @param: count
     * @return: java.util.List<java.lang.Object>
     */
    public static List<String> sPop(String key, long count){
        return redisTemplate.opsForSet().pop(key, count);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:47:03
     * @description: 获取多个集合之间的交集
     * @param: key
     * @param: otherKey
     * @return: java.util.Set<java.lang.Object>
     */
    public static Set<String> sIntersect(String key, Set<String> otherKey){
        return redisTemplate.opsForSet().intersect(key, otherKey);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:43:51
     * @description: 获取集合的大小
     * @param: key
     * @return: java.lang.Long
     */
    public static Long sSize(String key){
        return redisTemplate.opsForSet().size(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:38:52
     * @description: 往集合中添加元素（支持一次添加多个）
     * @param: key
     * @param: value
     * @return: java.lang.Long
     */
    public static Long sAdd(String key, String... values){
        return redisTemplate.opsForSet().add(key, values);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:44:48
     * @description: 判断集合中是否包含某个值
     * @param: key
     * @param: value
     * @return: java.lang.Boolean
     */
    public static Boolean sIsMember(String key, Object value){
        return redisTemplate.opsForSet().isMember(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:47:03
     * @description: 获取两个集合之间的交集
     * @param: key
     * @param: otherKey
     * @return: java.util.Set<java.lang.Object>
     */
    public static Set<String> sIntersect(String key, String otherKey){
        return redisTemplate.opsForSet().intersect(key, otherKey);
    }

    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:47:03
     * @description: 获取多个集合之间的交集
     * @param: key
     * @param: otherKey
     * @return: java.util.Set<java.lang.Object>
     */
    public static Set<String> sIntersect(Set<String> keys){
        return redisTemplate.opsForSet().intersect(keys);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:49:56
     * @description: 获取两个集合之间的并集
     * @param: key
     * @param: otherKey
     * @return: java.util.Set<java.lang.Object>
     */
    public static Set<String> sUnion(String key, String otherKey){
        return redisTemplate.opsForSet().union(key, otherKey);
    }

    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:49:56
     * @description: 获取多个集合之间的并集
     * @param: key
     * @param: otherKey
     * @return: java.util.Set<java.lang.Object>
     */
    public Set<String> sUnion(Set<String> keys){
        return redisTemplate.opsForSet().union(keys);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:30:51
     * @description: 把key集合与otherKey集合的并集存储到destKey中
     * @param: key
     * @param: otherKey
     * @param: destKey
     * @return: java.lang.Long
     */
    public static Long sUnionAndStore(String key, String otherKey, String destKey){
        return redisTemplate.opsForSet().unionAndStore(key, otherKey, destKey);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:32:41
     * @description: 把key集合与多个集合的并集存储到destKey中
     * @param: key
     * @param: otherKeys
     * @param: destKey
     * @return: java.lang.Long
     */
    public static Long sUnionAndStore(String key, Collection<String> otherKeys, String destKey){
        return redisTemplate.opsForSet().unionAndStore(key, otherKeys, destKey);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:41:48
     * @description: 获取一个集合与另一个集合的差集
     * @param: key
     * @param: otherKey
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<String> sDifference(String key, String otherKey){
        return redisTemplate.opsForSet().difference(key, otherKey);
    }
    /**
     * @author: water76016
     * @createTime: 2022年10月24 00:49:56
     * @description: 获取多个集合之间的并集
     * @param: key
     * @param: otherKey
     * @return: java.util.Set<java.lang.Object>
     */
    public static Set<String> sUnion(String key, Set<String> otherKey){
        return redisTemplate.opsForSet().union(key, otherKey);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:44:03
     * @description: 获取一个集合与多个集合的差集
     * @param: key
     * @param: otherKeys
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<String> sDifference(String key, Collection<String> otherKeys){
        return redisTemplate.opsForSet().difference(key, otherKeys);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:49:26
     * @description: 获取一个集合与另一个集合的差集，并存储到destKey中
     * @param: key
     * @param: otherKey
     * @param: destKey
     * @return: java.lang.Long
     */
    public static Long sDifferenceAndStore(String key, String otherKey, String destKey){
        return redisTemplate.opsForSet().differenceAndStore(key, otherKey, destKey);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:53:28
     * @description: 获取一个集合与多个集合的差集，并存储到destKey中
     * @param: key
     * @param: otherKeys
     * @param: destKey
     * @return: java.lang.Long
     */
    public static Long sDifferenceAndStore(String key, Collection<String> otherKeys, String destKey){
        return redisTemplate.opsForSet().differenceAndStore(key, otherKeys, destKey);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:55:05
     * @description: 获取一个集合的所有元素
     * @param: key
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<String> sMembers(String key){
        return redisTemplate.opsForSet().members(key);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月08 23:58:39
     * @description: 随机返回集合中的一个元素
     * @param: key
     * @return: java.lang.Object
     */
    public static Object sRandomMembers(String key){
        return redisTemplate.opsForSet().randomMember(key);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月02 00:15:02
     * @description: 随机获取集合中count数量的元素
     * @param: key
     * @param: count
     * @return: java.util.List<java.lang.String>
     */
    public static List<String> sRandomMembers(String key, long count){
        List<String> list = redisTemplate.opsForSet().randomMembers(key, count);
        return list;
    }


    /************************有序集合相关操作********************************/
    /**
     * @author: water76016
     * @createTime: 2022年11月14 23:48:15
     * @description: 往有序集合里面添加元素
     * @param: key
     * @param: value
     * @param: score
     * @return: boolean
     */
    public static boolean zAdd(String key, String value, double score){
        return redisTemplate.opsForZSet().add(key, value, score);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月14 23:51:14
     * @description: 往有序集合里面批量添加元素
     * @param: key
     * @param: values
     * @return: java.lang.Long
     */
    public static Long zAdd(String key, Set<ZSetOperations.TypedTuple<String>> values){
        return redisTemplate.opsForZSet().add(key, values);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月03 23:41:03
     * @description: 获取一个分数范围内的集合元素
     * @param: key
     * @param: min
     * @param: max
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<String> zRangeByScore(String key, double min, double max){
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月14 23:53:30
     * @description: 批量移除有序集合中的元素
     * @param: key
     * @param: values
     * @return: java.lang.Long
     */
    public static Long zRemove(String key, Object... values){
        return redisTemplate.opsForZSet().remove(key, values);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月14 23:56:25
     * @description: 返回元素在有序集合中的排名，有序集合是按照score由小到大进行排列
     * @param: key
     * @param: value
     * @return: java.lang.Long
     */
    public static Long zRank(String key, Object value){
        return redisTemplate.opsForZSet().rank(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月14 23:58:50
     * @description: 返回元素在有序集合中的排名，按照score由大到小进行排列
     * @param: key
     * @param: value
     * @return: java.lang.Long
     */
    public static Long zReverseRank(String key, Object value){
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月03 23:39:40
     * @description: 获取集合的元素，同时获取里面的分数
     * @param: key
     * @param: start
     * @param: end
     * @return: java.util.Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<java.lang.String>>
     */
    public static Set<ZSetOperations.TypedTuple<String>> zRangeWithScores(String key, long start, long end){
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月04 00:56:41
     * @description: 获取集合的元素数量
     * @param: key
     * @param: min
     * @param: max
     * @return: java.lang.Long
     */
    public Long zCount(String key, double min, double max) {
        return redisTemplate.opsForZSet().count(key, min, max);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月03 23:42:53
     * @description: 获取一个分数范围内的集合元素以及它的分数，并从小到大排序
     * @param: key
     * @param: min
     * @param: max
     * @return: java.util.Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<java.lang.String>>
     */
    public static Set<ZSetOperations.TypedTuple<String>> zRangeByScoreWithScores(String key, double min, double max){
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月03 23:45:43
     * @description: 获取给定范围内，从offset开始的，count数量的元素和值，从小到大排序
     * @param: key
     * @param: min
     * @param: max
     * @param: offset
     * @param: count
     * @return: java.util.Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<java.lang.String>>
     */
    public static Set<ZSetOperations.TypedTuple<String>> zRangeByScoreWithScores(String key, double min, double max,
                                                                                 long offset, long count){
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max, offset, count);
    }
    /**
     * @author: water76016
     * @createTime: 2022年11月14 23:54:42
     * @description: 对有序集合中的某个value，增加delta的分数，并返回增加后的分数
     * @param: key
     * @param: value
     * @param: delta
     * @return: java.lang.Double
     */
    public static Double zIncrementScore(String key, String value, double delta){
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月04 00:55:01
     * @description: 获取某个范围内的集合元素以及分数，从大到小排序
     * @param: key
     * @param: min
     * @param: max
     * @return: java.util.Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<java.lang.String>>
     */
    public Set<ZSetOperations.TypedTuple<String>> zReverseRangeByScoreWithScores(
            String key, double min, double max) {
        return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key,
                min, max);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月04 00:50:39
     * @description: 根据score值查询集合元素，从大到小排序
     * @param: key
     * @param: min
     * @param: max
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<String> zReverseRangeByScore(String key, double min, double max){
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月03 23:19:18
     * @description: 获取集合的元素，从小到大进行排序
     * @param: key
     * @param: start
     * @param: end
     * @return: java.util.Set<java.lang.String>
     */
    public static Set<String> zRange(String key, long start, long end){
        return redisTemplate.opsForZSet().range(key, start, end);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月04 00:55:43
     * @description: 获取某个范围内集合的元素，由小到大排序，从offset偏移量开始，最多的数量为count个
     * @param: key
     * @param: min
     * @param: max
     * @param: offset
     * @param: count
     * @return: java.util.Set<java.lang.String>
     */
    public Set<String> zReverseRangeByScore(String key, double min,
                                            double max, long offset, long count) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max,
                offset, count);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月04 00:56:58
     * @description: 获取集合的大小
     * @param: key
     * @return: java.lang.Long
     */
    public Long zSize(String key) {
        return redisTemplate.opsForZSet().size(key);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月04 00:57:22
     * @description: 获取集合的大小
     * @param: key
     * @return: java.lang.Long
     */
    public Long zZCard(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }
    /**
     * @author: water76016
     * @createTime: 2023年02月04 00:58:27
     * @description: 获取值为value的元素的分数
     * @param: key
     * @param: value
     * @return: java.lang.Double
     */
    public Double zScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }
}
