package com.daixiaoyu.leetcode.middle.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-04 22:18
 **/
public class 最大子数组和 {
    /**
     * @author: water76016
     * @createTime: 2025年04月04 22:18:35
     * @description: 类似贪心的思路，只要当前和还大于等于0，都可以往后面加
     * 这里要注意几点
     * 1.题干里面没有要求所有数字都为正数，所以result的初始值应该为数组的第一个值
     * 2.cur的定义为前面的值 + 当前的值，那么每次都要跟result进行比较取最大值
     * 3.如果cur<0，则认为前面那段都是无效数据，重新从0开始
     * @param: nums
     * @return: int
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int cur = 0;
        for (int num : nums){
            cur = cur + num;
            //每次都要比较和当前结果的最大值
            result = Math.max(cur, result);
            if (cur < 0) {
                //把cur重置为0
                cur = 0;
            }
        }
        return result;
    }
}
