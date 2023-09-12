package com.daixiaoyu.daixiaoyuleetcode.array;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-13 00:56
 **/
public class 合并两个有序数组 {
    /**
     * 原地移动，从后往前遍历，哪个数字比较大，就把哪个数字放在后面
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (index >= 0){
            //两个数组都有值，谁大谁放在后面
            if (m >= 0 && n >= 0){
                if (nums1[m] > nums2[n]){
                    nums1[index] = nums1[m];
                    m--;
                }
                else {
                    nums1[index] = nums2[n];
                    n--;
                }
            }
            //只剩下nums1有值
            else if (m >= 0){
                nums1[index] = nums1[m];
                m--;
            }
            else if (n >= 0){
                nums1[index] = nums2[n];
                n--;
            }
            //每次都要向前移动一步
            index--;
        }
    }
}
