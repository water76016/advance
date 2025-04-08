package com.daixiaoyu.leetcode.middle.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:编辑距离
 * 设dp[i][j]表示word1的前i个字符，到word2的前j个字符的编辑距离
 * 那么：dp[i][j] = min(dp[i-1][j-1] + 1, dp[i][j-1] + 1, dp[i-1][j] + 1)
 * @version: v1.0.0
 * @create: 2025-04-08 23:39
 **/
public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0){
            return word2.length();
        }
        if (word2 == null || word2.length() == 0){
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //设置初始值
        for (int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
