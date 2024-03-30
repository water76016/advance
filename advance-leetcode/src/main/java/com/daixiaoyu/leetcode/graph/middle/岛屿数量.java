package com.daixiaoyu.leetcode.graph.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * @version: v1.0.0
 * @create: 2024-03-31 02:46
 **/
public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int result = 0;
        //定义一个相同大小的数据，来判断是否已经遍历
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        //存储横坐标
        Queue<Integer> x = new LinkedList<Integer>();
        //存储纵坐标
        Queue<Integer> y = new LinkedList<Integer>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                //找到数组中，为1（大陆）的点,并且该点没有被遍历过，作为遍历的起始点
                if (grid[i][j] == '1' && flag[i][j] == false){
                    result++;
                    x.offer(i);
                    y.offer(j);
                    flag[i][j] = true;
                    while (x.isEmpty() == false){
                        //获取队列的第一个元素
                        int tempX = x.element();
                        int tempY = y.element();
                        //把该元素的没有被访问过的邻居点，邻居点为1的加入都加入到队列中，并且把状态设置为已经访问过
                        if (tempX - 1 >= 0){
                            if (flag[tempX - 1][tempY] == false && grid[tempX - 1][tempY] == '1'){
                                flag[tempX - 1][tempY] = true;
                                x.offer(tempX - 1);
                                y.offer(tempY);
                            }
                        }
                        if (tempX + 1 < m){
                            if (flag[tempX + 1][tempY] == false && grid[tempX + 1][tempY] == '1'){
                                flag[tempX + 1][tempY] = true;
                                x.offer(tempX + 1);
                                y.offer(tempY);
                            }
                        }
                        if (tempY - 1 >= 0){
                            if (flag[tempX][tempY - 1] == false && grid[tempX][tempY - 1] == '1'){
                                flag[tempX][tempY - 1] = true;
                                x.offer(tempX);
                                y.offer(tempY - 1);
                            }
                        }
                        if (tempY + 1 < n){
                            if (flag[tempX][tempY + 1] == false && grid[tempX][tempY + 1] == '1'){
                                flag[tempX][tempY + 1] = true;
                                x.offer(tempX);
                                y.offer(tempY + 1);
                            }
                        }
                        //把该节点，从队列中移除
                        x.poll();
                        y.poll();
                    }
                }
            }
        }
        return result;
    }
}
