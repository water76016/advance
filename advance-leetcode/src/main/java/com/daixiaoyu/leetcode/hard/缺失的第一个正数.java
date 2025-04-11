package com.daixiaoyu.leetcode.hard;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-10 23:12
 **/
public class 缺失的第一个正数 {
    public static void main(String[] args) {
        int [] nums = {7,8,9,11,12};
        firstMissingPositive(nums);
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月10 23:12:40
     * @description: 考虑利用数组下标，对数据进行修改，把值放到对应下标看是否能实现
     * @param: nums
     * @return: int
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            //画重点：因为我只需要在乎1-n的，所以取值范围一定要在1-n才行
            while (nums[i] > 0 && nums[i] <= n &&  nums[i] != nums[nums[i] - 1]){
                //说明下标位置不对，需要不断进行交换
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] == i + 1){
                continue;
            }
            return i + 1;
        }
        return nums.length + 1;
    }
}
