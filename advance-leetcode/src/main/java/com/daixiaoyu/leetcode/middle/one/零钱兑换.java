package com.daixiaoyu.leetcode.middle.one;

import java.util.Arrays;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-09 08:07
 **/
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        //画重点，这里一定要先排序，不然可能会出问题
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin : coins){
                if (i - coin < 0){
                    break;
                }
                if (dp[i - coin] == -1){
                    //说明前一个也没找到，跳过
                    continue;
                }
                if (dp[i] == -1){
                    dp[i] = dp[i - coin] + 1;
                }
                else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}
