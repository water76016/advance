package com.daixiaoyu.leetcode.middle.two;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-11 08:22
 **/
public class 和为K的子数组 {
    /**
     * @author: water76016
     * @createTime: 2025年04月11 08:22:55
     * @description: 考虑用动态规划来做。
     * 设dp[i][j]表示下标从i到j的数组的和，
     * 最后遍历这个dp，就能得到和为k的子数组的个数了
     * @param: nums
     * @param: k
     * @return: int
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        //先对dp进行初始化
        for (int i = 0; i < n; i++){
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                dp[i][j] = dp[i][j - 1] + nums[j];
            }
        }
        //对dp进行遍历，看有多少个和为K的子数组
        int result = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (dp[i][j] == k){
                    result++;
                }
            }
        }
        return result;
    }
}
