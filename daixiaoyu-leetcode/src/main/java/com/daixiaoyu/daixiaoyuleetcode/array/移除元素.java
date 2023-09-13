package com.daixiaoyu.daixiaoyuleetcode.array;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-13 23:24
 **/
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        //设置pre指针，这个指针一直指向不需要移除的位置
        int pre = 0;
        if (nums == null || nums.length == 0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++){
            //如果不需要移除，则将后面的值赋给前面
            if (nums[i] != val){
                nums[pre] = nums[i];
                pre++;
            }
        }
        return pre;
    }
}
