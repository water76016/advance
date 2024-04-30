package com.daixiaoyu.leetcode.array.sort.middle;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2024-03-31 00:11
 **/
public class 数组中第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        //构建好之后，每次将根节点与最后一个节点交换，那么最大的值就会跑到最后去，等k次结束后，索引0的位置就是根节点，也就是第K大的数了
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--){
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize){
        for (int i = heapSize / 2 - 1; i >= 0; i--){
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize){
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        //从根左右节点中找最大的那个索引
        if (l < heapSize && a[l] > a[largest]){
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]){
            largest = r;
        }
        //不等于说明左节点或者右节点比当前节点大，需要交换
        if (largest != i){
            swap(a, i, largest);
            //继续调用这个是因为largest的点发生了变更，因此需要对它继续进行堆的调整
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
