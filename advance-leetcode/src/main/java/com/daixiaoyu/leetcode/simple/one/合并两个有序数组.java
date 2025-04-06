package com.daixiaoyu.leetcode.simple.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 21:51
 **/
public class 合并两个有序数组 {
    /**
     * @author: water76016
     * @createTime: 2025年04月06 21:52:16
     * @description: 因为要把结果放到nums1里面，所以是从后往前进行遍历
     * @param: nums1
     * @param: m
     * @param: nums2
     * @param: n
     * @return: void
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (total >= 0){
            if (index1 >= 0 && index2 >= 0){
                if (nums1[index1] > nums2[index2]){
                    nums1[total] = nums1[index1];
                    index1--;
                }
                else {
                    nums1[total] = nums2[index2];
                    index2--;
                }
            }
            else if (index1 >= 0){
                nums1[total] = nums1[index1];
                index1--;
            }
            else {
                nums1[total] = nums2[index2];
                index2--;
            }
            total--;
        }
    }
}
