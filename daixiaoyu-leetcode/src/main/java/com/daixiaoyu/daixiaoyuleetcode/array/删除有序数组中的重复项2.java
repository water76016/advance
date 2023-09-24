package com.daixiaoyu.daixiaoyuleetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-14 00:45
 **/
public class 删除有序数组中的重复项2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null){
            return 0;
        }
        if (nums.length <= 2){
            return nums.length;
        }
        int pre = 0;
        for (int i = 1; i < nums.length; i++){
            int val = nums[i];
            //当前面的数和后面的数不相等的时候,或者隔开一个数也不相等的时候，说明可以移动，因为是有序的
            if (nums[pre] != val || (pre - 1 < 0) || (pre - 1 >= 0 && nums[pre - 1] != val)){
                pre++;
                nums[pre] = val;
            }
        }
        return pre + 1;
    }
}
