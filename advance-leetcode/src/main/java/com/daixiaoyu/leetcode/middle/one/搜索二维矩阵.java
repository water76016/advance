package com.daixiaoyu.leetcode.middle.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-31 22:32
 **/
public class 搜索二维矩阵 {
    /**
     * @author: water76016
     * @createTime: 2025年03月31 22:32:43
     * @description: 这里题干虽然说的是：从左到右递增，
     * 每行的第一个大于上一行的最后一个。那么换种说法就是从上到下也是递增
     * 那么总右上角开始寻找即可
     * @param: matrix
     * @param: target
     * @return: boolean
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int curX = 0;
        int curY = n - 1;
        while (curX >= 0 && curX < m && curY >= 0 && curY < n){
            if (matrix[curX][curY] == target){
                return true;
            }
            else if (matrix[curX][curY] >= target){
                //比target还大，说明那一列要去掉
                curY--;
            }
            else {
                curX++;
            }
        }
        return false;
    }
}
