package com.daixiaoyu.leetcode.todo.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 21:28
 **/
public class 最长连续序列 {
    /**
     * @author: water76016
     * @createTime: 2025年03月30 21:28:39
     * @description:
     * 1.先用set进行存储，方便判断某个值是否在数组里面
     * 2.遍历当前值x的时候，如果x-1在集合里面，直接跳过
     * 3.如果x-1不在集合里面，则以x为起点，不断往后x+1,x+2，判断是否在集合里面，不断更新result的结果
     * 4.返回最大值
     * @param: nums
     * @return: int
     */
    public int longestConsecutive(int[] nums) {
        //set方便判断一个元素是否在集合里面
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        //定义结果变量
        int result = 0;
        for (int num : nums){
            if (set.contains(num - 1)){
                continue;
            }
            //为了减少遍历次数，直接判断num + result是否在集合里面。不包含，说明肯定没result大
            if(!set.contains(num + result)){
                continue;
            }
            //不包含，以num为起点，往后遍历
            int step = 1;
            while (set.contains(num + step)){
                step++;
            }
            result = Math.max(result, step);
        }
        return result;
    }
}
