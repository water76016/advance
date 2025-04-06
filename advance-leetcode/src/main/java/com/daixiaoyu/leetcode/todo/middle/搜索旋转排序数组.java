package com.daixiaoyu.leetcode.todo.middle;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 10:54
 **/
public class 搜索旋转排序数组 {
    /**
     * @author: water76016
     * @createTime: 2025年04月06 11:14:24
     * @description: 二分法在进行比较的时候
     * 需要注意把3个值都和目标值都进行比较，left、right、middle的值
     * 如果目标值在
     * 根据范围就能判断目标值到底是在middle的左边还是右边
     * @param: args
     * @return: void
     */
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        搜索旋转排序数组 main = new 搜索旋转排序数组();
        main.search(nums, 0);
    }

    public int search(int[] nums, int target) {
        //处理只有一个数的特殊情况
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1 && nums[0] == target){
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        //画重点：注意在二分法的时候，left是可以跟right相等的
        while (left <= right){
            int middle = (right + left) / 2;
            if (nums[middle] == target){
                return middle;
            }
            else {
                /**
                 * 画重点：else这里，需要确定到底是左边有序，还是右边有序，因为旋转后，肯定有一边还是有序的
                 * 确定的方法在于，把当前middle的值，跟left的位置做比较就行
                 */
                //如果左边有序
                if (nums[middle] >= nums[left]){
                    //左边有序的话，先判断是否在左边，否则就在右边
                    if (nums[middle] > target && target >= nums[left]){
                        right = middle - 1;
                    }
                    else {
                        left = middle + 1;
                    }
                }
                //否则就是右边有序
                else {
                    //右边有序的话，先判断是否在右边，否则就在左边
                    if (nums[n - 1] >= target && target > nums[middle]){
                        left = middle + 1;
                    }
                    else {
                        right = middle - 1;
                    }
                }
            }
        }
        return -1;
    }
}