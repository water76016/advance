package com.daixiaoyu.leetcode.middle.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-09 08:17
 **/
public class 最长公共子序列 {
    /**
     * @author: water76016
     * @createTime: 2025年04月09 08:24:50
     * @description: 最长公共子序列
     * 这道题用动态规划来做
     * 设dp[i][j]为text1的前i个字符和text2的前j个字符，所组成的最长公共子序列
     * 那么：当i和j两个位置的字符相等的时候，dp[i][j] = dp[i-1][j-1] + 1
     * 当i和j两个位置的字符不相等的时候，d[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
     * 另外，在初始化的时候，dp[0][j] = 0   dp[i][0] = 0
     *
     * //画重点：这里在进行dp[i][j]的时候，c1和c2获取的是i-1和j-1的字符是对的
     * 因为，字符串是从0开始的，所以需要减一位
     * @param: text1
     * @param: text2
     * @return: int
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        //似乎都是0，不用初始化
        for (int i = 1; i <= m; i++){
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++){
                char c2 = text2.charAt(j - 1);
                if (c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
