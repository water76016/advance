package com.daixiaoyu.daixiaoyuleetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-13 23:48
 **/
public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int pre = 0;
        for (int i = 1; i < nums.length; i++){
            //当前面的数和后面的数不相等的时候，说明可以移动
            if (nums[pre] != nums[i]){
                pre++;
                nums[pre] = nums[i];
            }
        }
        return pre + 1;
    }
}
