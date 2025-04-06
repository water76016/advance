package com.daixiaoyu.leetcode.todo.middle;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-04 23:26
 **/
public class 最长回文子串 {
    public static void main(String[] args) {
        最长回文子串 main = new 最长回文子串();
        System.out.println(main.longestPalindrome("babad"));
    }

    /**
     * @author: water76016
     * @createTime: 2025年04月04 23:26:40
     * @description: 用动态规划来做
     * 设dp[i][j]表示从位置i到j的的最大回文子串长度
     *
     *
     *abcdcba  ->
     *
     * abcdc = 3 dp[2][4] = 3
     * abcdcb = 4 dp[1][5] = 5
     * abcdcba = 5 dp[0][6] = 7
     *
     * dp[i - 1][j + 1] = dp[i][j] + 2 判断那两个位置是否相等
     * dp[i][i]都为1
     *
     *
     *
     * @param: s
     * @return: java.lang.String
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int n = s.length();
        String result = String.valueOf(s.charAt(0));
        //s的最大长度是n，所以
        boolean[][] dp = new boolean[n][n];
        //填充序列长度为1的情况
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        //开始进行循环。因为dp的定义是i到j的位置，因此，需要从后往前遍历
        //外层循环不断往左移动
        for (int i = n - 1; i >=0; i--){
            //内存循环不断往右移动
            for (int j = i + 1; j < n; j++){
                //这里的判断条件要注意，首尾两个字符相等，且后面是一个括号中的或
                if (s.charAt(i) == s.charAt(j) && ((j - i <= 1) || dp[i + 1][j - 1])){
                    //满足回文串的条件，累加
                    dp[i][j] = true;
                    if (j - i + 1 > result.length()){
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

}
