package com.daixiaoyu.leetcode.middle.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-31 23:33
 **/
public class 矩阵置零 {
    /**
     * @author: water76016
     * @createTime: 2025年03月31 23:33:20
     * @description:
     * 1.先进行一次遍历，看第一列和第一行是否有0
     * 2.然后后面把第一列和第一行，作为标志位进行存储。如果某行某列为0，则那那个点的第一行第一列的
     * 对应元素也置为0。那么最后只需要遍历第一行和第一列，就能把所有的元素都置为0了
     * 3.最后再看第一步的第一行和第一列是否本身有0，若有，则把对应的也置为0
     * @param: matrix
     * @return: void
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rawHavZero = false;
        boolean colHavZero = false;
        //看第一行是否本身有0
        for (int j = 0; j < n; j++){
            if (matrix[0][j] == 0){
                rawHavZero = true;
                break;
            }
        }
        //看第一列是否本身有0
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == 0){
                colHavZero = true;
                break;
            }
        }
        //从第二行的第二列开始遍历
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    //把对应的那一行，和那一列的元素置为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //遍历处理后的第一行和第一列，对所有数据点进行赋值
        //todo:这里要特别注意，不能修改原有的那一行和那一列，否则会导致全为0，所以是从1开始
        for (int j = 1; j < n; j++){
            if (matrix[0][j] == 0){
                //把所有的第j列，都赋值为0
                for (int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        //todo:这里要特别注意，不能修改原有的那一行和那一列，否则会导致全为0，所以是从1开始
        for (int i = 1; i < m; i++){
            if (matrix[i][0] == 0){
                //把所有的第i行都赋值为0
                for (int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        //根据最开始的标记为，看第一行和第一列，是否要置为0
        if (rawHavZero){
            for (int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if (colHavZero){
            for (int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        矩阵置零 main = new 矩阵置零();
        main.setZeroes(nums);
    }
}
