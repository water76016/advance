package com.daixiaoyu.daixiaoyuleetcode.array;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-24 23:49
 **/
public class 跳跃游戏2 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        //先初始化为最大值
        for (int i = 0; i < length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        int max = nums[0];
        for (int i = 1; i <= max; i++){
            //这里注意一下，有可能一下子就跳出去了
            if(max >= length){
                return 1;
            }
            dp[i] = 1;
        }
        for (int i = 1; i < length; i++){
            if (max < i){
                return -1;
            }
            //更新最远距离
            max = Math.max(max, nums[i] + i);
            for (int j = i; j <= nums[i] + i; j++){
                if (j < length){
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[length - 1];
    }
}
