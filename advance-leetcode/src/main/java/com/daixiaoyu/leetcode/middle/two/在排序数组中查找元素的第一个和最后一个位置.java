package com.daixiaoyu.leetcode.middle.two;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-11 19:54
 **/
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int min = find(nums, target, false);
        int max = find(nums, target, true);
        return new int[]{min, max};
    }

    public int find(int[] nums, int target, boolean big){
        int left = 0;
        int right = nums.length - 1;
        //定义结果
        int result = -1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (big){
                //画重点。主要是这个判断，如果往大了找的话，所以小于等于要往右边移动
                if (nums[middle] <= target){
                    if (nums[middle] == target){
                        result = middle;
                    }
                    left = middle + 1;
                }
                else {
                    right = middle - 1;
                }
            }
            else {
                //如果往小了找的话，大于等于，才能往左边移动
                if (nums[middle] >= target){
                    if (nums[middle] == target){
                        result = middle;
                    }
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
        }
        return result;
    }
}
