package com.daixiaoyu.leetcode;

import com.daixiaoyu.leetcode.entity.ListNode;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2024-03-17 16:15
 **/
public class Main {
    public static void main(String[] args) {

    }

    public void sortArray(int[] nums){
        if (nums == null || nums.length <= 1){
            return;
        }
        sortArray(nums, 0, nums.length - 1);
    }

    public void sortArray(int[] nums, int low ,int high){
        //该值定义了从哪个位置开始分隔序列
        if (low < high){
            int pivot = partition(nums, low, high);
            sortArray(nums, low, pivot - 1);
            sortArray(nums, pivot + 1, high);
        }
    }

    //快排的序列分隔函数
    public int partition(int[] nums, int low, int high){
        //取每个序列的第一个值作为基准值
        int pivotValue = nums[low];
        while (low < high){
            //从序列的右边开始往左遍历，直到找到小于基准值的元素
            while (high > low && nums[high] >= pivotValue){
                high--;
            }
            //将元素赋值给左边第一个，即pivot所在的位置
            nums[low] = nums[high];
            //从序列的左边开始遍历，直到找到第一个大于基准值的元素
            while (high > low && nums[low] <= pivotValue){
                low++;
            }
            //最后找到了之后，又赋值给右边
            nums[high] = nums[low];
        }
        //最后的low就是基准值所在的位置
        nums[low] = pivotValue;
        return low;
    }
}