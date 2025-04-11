package com.daixiaoyu.leetcode.middle.one;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 21:24
 **/
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        //定义结果集
        List<List<Integer>> result = new ArrayList<>();
        //定义临时结果
        List<Integer> output = new ArrayList<>();
        for (int num : nums){
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, result, output, 0);
        return result;
    }

    public void backtrack(int n, List<List<Integer>> result, List<Integer> output, int first){
        if (n == first){
            //说明可以收集结果了
            result.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++){
            //先交换位置
            Collections.swap(output, first, i);
            //跌打下一个
            backtrack(n, result, output, first + 1);
            //交换回来
            Collections.swap(output, first, i);
        }
    }
}
