package com.daixiaoyu.leetcode.simple.two;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-09 22:31
 **/
public class x的平方根 {
    /**
     * @author: water76016
     * @createTime: 2025年04月09 22:31:54
     * @description: 使用二分法，不断除以2，不断逼近最终结果
     * @param: x
     * @return: int
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = 0;
        while (left <= right){
            int middle = left + (right - left) / 2;
            //画重点，这里可能数据溢出，所以得转换为long
            //画重点，这里判断为<=，而不是小于判断一次，等于判断一次，是因为可以减少乘法的次数
            if ((long)middle * middle <= x){
                //画重点：这里的result应该是赋值为middle
                result = middle;
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return result;
    }
}
