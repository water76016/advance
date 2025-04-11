package com.daixiaoyu.leetcode.middle.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-10 23:17
 **/
public class 数组中重复的数据 {
    /**
     * @author: water76016
     * @createTime: 2025年04月10 23:17:24
     * @description: 数据都在1-n内，那么把数组当作哈希表，进行存储即可
     * @param: nums
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> findDuplicates(int[] nums) {
        //定义结果集
        List<Integer> result = new ArrayList<>();
        int n = nums.length;


        for (int i = 0; i < n; i++){
            while (nums[i] != nums[nums[i] - 1]){
                //开始交换
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        //交换完之后，所有的下标跟数字都对上了，再对数组进行一次遍历即可
        for (int i = 0; i < n; i++){
            if (nums[i] - 1 != i){
                result.add(nums[i]);
            }
        }
        return result;
    }
}
