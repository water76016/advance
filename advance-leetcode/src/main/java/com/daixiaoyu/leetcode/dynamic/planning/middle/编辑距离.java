package com.daixiaoyu.leetcode.dynamic.planning.middle;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * - 插入一个字符
 * - 删除一个字符
 * - 替换一个字符
 * @version: v1.0.0
 * @create: 2024-04-27 17:35
 **/

/**
 * 题解：
 * 定义dp[i][j]
 * dp[i][j]代表word1中前i个字符，变换到word2中前j个字符，需要的最短次数
 * 那么：
 * 增：dp[i][j] = dp[i][j - 1] + 1
 * 删：dp[i][j] = dp[i - 1][j] + 1
 * 改：dp[i][j] = dp[i - 1][j - 1] + 1
 * 这样的话，当计算dp[i][j]的时候，将前面3个，取最小值，就可以更新dp[i][j]的值了
 * 需要注意的是，当从word1[i] = word2[j]的时候，取值可以直接为dp[i - 1][j - 1]
 *
 * 另外，由于变换的是长度，那么定义的save数组，大小应该是[n+1][m+1]
 */
public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0){
            return word2.length();
        }
        if (word2.length() == 0){
            return word1.length();
        }
        int n = word1.length();
        int m = word2.length();
        int[][] save = new int[n + 1][m + 1];
        save[0][0] = 0;
        for (int i = 1; i <= n; i++){
            save[i][0] = save[i - 1][0] + 1;
        }
        for (int j = 1; j <= m; j++){
            save[0][j] = save[0][j - 1] + 1;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    save[i][j] = save[i - 1][j - 1];
                    continue;
                }
                save[i][j] = Math.min(save[i][j - 1], save[i - 1][j]) + 1;
                save[i][j] = Math.min(save[i][j], save[i - 1][j - 1] + 1);
            }
        }
        return save[n][m];
    }
}
