package com.daixiaoyu.leetcode.todo.middle;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-31 22:53
 **/
public class 旋转图像 {
    /**
     * @author: water76016
     * @createTime: 2025年03月31 22:53:45
     * @description: 先上下翻转，再主对角线翻转
     * @param: matrix
     * @return: void
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //上下翻转
        for (int i = 0; i < m / 2; i++){
            for (int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - i][j];
                matrix[m - 1 - i][j] = temp;
            }
        }
        //主对角线翻转
        for (int i = 0; i < m; i++){
            for (int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
