package com.daixiaoyu.leetcode.middle.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-31 23:01
 **/
public class 螺旋矩阵 {
    //todo:这里主要是上下左右的指针没弄对，另外，这里要注意最后一个从左下到左上，那个条件是不能等于的
    /**
     * @author: water76016
     * @createTime: 2025年03月31 23:01:29
     * @description:
     * 做法是从外到内一层一层往里面遍历
     * 难点在于指针的处理
     * 还需要注意特殊情况，最后只剩下一行，或只剩下一列
     * @param: matrix
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        //定义结果集
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        //定义四个顶点的索引
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;

        while (left <= right && top <= bottom){
            //左上到右上
            for (int y = left; y <= right; y++){
                result.add(matrix[top][y]);
            }
            //从右上到右下
            for (int x = top + 1; x <= bottom; x++){
                result.add(matrix[x][right]);
            }
            //这里后面可能会出现只有一行或一列的情况，所以需要特殊判断
            if (left < right && top < bottom){
                //从右下到左下
                for (int y = right - 1; y >= left; y--){
                    result.add(matrix[bottom][y]);
                }
                //从左下到左上
                for (int x = bottom - 1; x > top; x--){
                    result.add(matrix[x][left]);
                }
            }
            //移动指针
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}
