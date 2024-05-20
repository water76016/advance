package com.daixiaoyu.leetcode.dynamic.planning.middle;

import java.util.Arrays;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 * @version: v1.0.0
 * @create: 2024-05-20 22:41
 **/
public class 零钱兑换 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin : coins){
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if(dp[amount] > amount){
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }
}
