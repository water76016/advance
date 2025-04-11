package com.daixiaoyu.leetcode.middle.two;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-09 22:57
 **/
public class 最长重复子数组 {
    /**
     * @author: water76016
     * @createTime: 2025年04月09 22:57:22
     * @description: 这道题要用动态规划来做
     * 设dp[i][j]表示第一个数组的前i个字符，到第二个数组的前j个字符的的最长重复子数组
     * 那么。对dp[i][j]来说，会存在几种情况
     * 如果第i个数字等于第j个数字，那么dp[i][j] = dp[i-1][j-1] + 1
     * 如果不相等的话，dp[i][j] = dp[i-1][j-1],dp[i][j-1],dp[i-1][j]，三者的最大值
     * @param: nums1
     * @param: nums2
     * @return: int
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        //对dp进行初始化
        for (int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++){
            dp[0][j] = 0;
        }
        //画重点：这里一定要定义res，每次对res进行更新才行，因为这个dp不是叠加的
        //dp[m][n]不一定包含dp[m-1][n]这样，所以一定要定义res才行
        int res = 0;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                //这里要注意的是，因为定义是前i和字符和前j个字符，数组的下标是从0开始的，那么得变成i-1和j-1
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
