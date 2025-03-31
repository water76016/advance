package com.daixiaoyu.leetcode.middle.one;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 23:47
 **/
public class 盛水最多的容器 {
    /**
     * @author: water76016
     * @createTime: 2025年03月30 23:47:57
     * @description:
     * 双指针，不断往中间移动，不断更新最大值
     * 每次去掉最短的那个
     *
     * 这道题用双指针的思路也可以这么理解：
     * 贪心的想法。如果左右两边总要去掉一个，中间的长度又是随机的
     * 那么，去掉较短的那个，肯定最后得到更大的结果的概率，总是更大一点
     * @param: height
     * @return: int
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right){
            int cur = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, cur);
            //去掉最短的那个
            if (height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return result;
    }
}
