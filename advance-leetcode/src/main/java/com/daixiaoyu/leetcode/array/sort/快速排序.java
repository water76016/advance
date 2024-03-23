package com.daixiaoyu.leetcode.array.sort;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * 对一个未排序的序列，从该序列中的元素中取一个基准值pivot，将小于基准值的元素放在左边，将大于基准值的元素放在右边
 * 接着以该基准值为中间，左右两边分割成新的序列，重新进行1操作
 * @version: v1.0.0
 * @create: 2024-03-23 12:45
 **/
public class 快速排序 {
    public void quickSort(int[] a){
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int low, int high){
        //该值定义了从哪个位置开始分割序列
        int pivot;
        if (low < high){
            pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    /**
     * 返回基准点（返回的是数组中的一个位置，而不是一个值）
     * 取每一个序列的第一个作为基准值
     * @return
     */
    public int partition(int[] a, int low, int high){
        int pivot = a[low];
        while (low < high){
            //从序列的右边开始往左遍历，直到找到小于基准值的元素
            while (high > low && a[high] >= pivot){
                high--;
            }
            //将元素赋值给左边第一个，即pivot所在的位置
            a[low] = a[high];
            //从序列的左边开始往右遍历，直到找到大于基准值的元素
            while (high > low && a[low] <= pivot){
                low++;
            }
            a[high] = a[low];
        }
        //最后的low是基准值的位置
        a[low] = pivot;
        return low;
    }
}
