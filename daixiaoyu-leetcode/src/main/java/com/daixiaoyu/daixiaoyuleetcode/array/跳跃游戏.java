package com.daixiaoyu.daixiaoyuleetcode.array;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-24 23:42
 **/
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            //先判断能不能跳到i的位置
            if (max < i){
                return false;
            }
            //更新max的大小
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length){
                return true;
            }
        }
        return true;
    }
}
