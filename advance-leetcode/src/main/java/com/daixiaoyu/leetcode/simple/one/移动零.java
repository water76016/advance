package com.daixiaoyu.leetcode.simple.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 23:35
 **/
//todo:
public class 移动零 {
    /**
     * 这道题我没有一次过，这是因为：我之前要两个指针进行移动，然后进行赋值。
     *
     * 但我忘了把noZero后面的元素都置为0了，导致不满足题目要求。
     */



    /**
     * @author: water76016
     * @createTime: 2025年03月30 23:35:39
     * @description:
     * 定义两个指针，一个指向非0的位置，一个指向当前位置
     * 不断地把当前位置非0的元素，往前面复制就可以
     * @param: nums
     * @return: void
     */
    public void moveZeroes(int[] nums) {
        int noZero = 0;
        int cur = 0;
        while (cur < nums.length){
            if (nums[cur] != 0){
                //进行复制
                nums[noZero] = nums[cur];
                noZero++;
            }
            //cur指针都会往前移动
            cur++;
        }
        //遍历完之后，把noZero后面的元素都置为0
        while(noZero < nums.length){
            nums[noZero] = 0;
            noZero++;
        }
    }
}
