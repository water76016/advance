package com.daixiaoyu.leetcode.simple.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 20:25
 **/
public class 两数之和 {
    /**
     * @author: wate r76016
     * @createTime: 2025年03月30 20:26:53
     * @description: 用Map来存储数组下标
     * @param: nums
     * @param: target
     * @return: int[]
     */
    public int[] twoSum(int[] nums, int target) {
        //用map来存储数组下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if (map.containsKey(remain)){
                return new int[]{map.get(remain), i};
            }
            //不满足条件的话，则把当前值放到map里面去
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
