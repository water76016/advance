package com.daixiaoyu.leetcode.riddle.simple;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * 给你一个正整数 n ，开始时，它放在桌面上。在 109 天内，每天都要执行下述步骤：
 *
 * - 对于出现在桌面上的每个数字 x ，找出符合 1 <= i <= n 且满足 x % i == 1 的所有数字 i 。
 * - 然后，将这些数字放在桌面上。
 *
 * 返回在 109 天之后，出现在桌面上的 不同 整数的数目。
 * @version: v1.0.0
 * @create: 2024-03-23 13:59
 **/
public class 统计桌面上的不同数字 {
    /**
     * @author: water76016
     * @createTime: 2024年03月23 14:00:08
     * @description: 比如从n开始，那么n-1一定是满足题目的一个结果
     * 对n-1来说，n-2又是满足题目的一个结果
     * 对n-2来说，n-3又是满足题目的一个结果
     * 依次类推
     * @param: n
     * @return: int
     */
    public int distinctIntegers(int n) {
        if (n == 1){
            return 1;
        }
        return n - 1;
    }
}
