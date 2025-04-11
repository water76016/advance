package com.daixiaoyu.leetcode.middle.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-04 22:29
 **/
public class 快速排序 {
    public static void main(String[] args) {
        快速排序 main = new 快速排序();
        int[] a = {2, 5, 1, 1, 3, 7, 7, 9, 11, 4, 2};
        main.sortArray(a);
        for (int i : a){
            System.out.println(i);
        }
    }

    public void sortArray(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int low, int high){
        //该值定义了从哪个位置开始分隔序列
        int pivot;
        if (low < high){
            pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }
    //快排的序列分割函数
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
            //从序列的左边开始遍历，直到找到大于基准值的元素
            while (high > low && nums[low] <= pivotValue){
                low++;
            }
            //最后找到了之后，又把这个值赋值给右边
            nums[high] = nums[low];
        }
        //最后的low就是基准值所在的位置
        nums[low] = pivotValue;
        return low;
    }
}
