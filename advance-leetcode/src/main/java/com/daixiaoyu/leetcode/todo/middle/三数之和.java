package com.daixiaoyu.leetcode.todo.middle;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-04 21:48
 **/
public class 三数之和 {
    /**
     * @author: water76016
     * @createTime: 2025年04月04 21:50:25
     * @description:
     * 1.首先，题目要求结果集不能重复，那先给数组排序
     * 对于a+b+c=0,只要满足a<b<c这个，那么结果就不会重复
     * 2.其次，假设a固定，当b增大，c必然减少，b减小，c必然增大，那么可以用双指针
     * @param: nums
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++){
            //判断当前数跟上一个是否相同，如果相同，则跳过
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                //同样判断left是否跟上一个相同
                if (left > i + 1 && nums[left] == nums[left - 1]){
                    left++;
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] == 0){
                    //收集结果
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
                else if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
