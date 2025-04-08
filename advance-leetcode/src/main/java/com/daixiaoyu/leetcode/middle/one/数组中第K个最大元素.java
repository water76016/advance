package com.daixiaoyu.leetcode.middle.one;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-04 17:14
 **/
public class 数组中第K个最大元素 {
    /**
     * @author: water76016
     * @createTime: 2025年04月04 17:14:55
     * @description: 这个需要用到堆排序，可以用Java的优先级队列来实现
     * @param: nums
     * @param: k
     * @return: int
     */
    public int findKthLargestOne(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums){
            //如果容量还够，就直接放进去
            if (queue.size() < k){
                queue.add(num);
                continue;
            }
            //容量不够了，需要把当前堆里面最小的那个数置换出来，刚好小顶堆的顶点是最小的，满足条件
            int top = queue.peek();
            if (top < num){
                queue.remove();
                queue.add(num);
            }

        }
        return queue.peek();
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月04 17:41:44
     * @description: 用桶排序的做法
     * 注意题干里面，限制了每个数的最大值和最小值，所以可以用桶排序
     * 用桶排序的时候注意，因为有负数，所以可以把负数弄成正数，
     * 用到的时候再替换回去
     * @param: nums
     * @param: k
     * @return: int
     */
    public int findKthLargest(int[] nums, int k) {
        //定义桶的大小，因为数据是正负10000，所以定义为20001
        int[] bucket = new int[20001];
        //把数据往桶里面放
        for (int num : nums){
            //画重点：这里由于数组的长度增加了10000，所以这里的Num也要增加10000
            bucket[num + 10000]++;
        }
        //从后往前计算
        for (int i = bucket.length - 1; i >= 0; i--){
            k = k - bucket[i];
            if (k <= 0){
                //说明找到那个数了，返回（前面增加了10000，这里就减10000）
                return i - 10000;
            }
        }
        return -1;
    }
}
