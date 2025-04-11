package com.daixiaoyu.leetcode.middle.one;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 19:57
 **/
public class 岛屿数量 {
    public static void main(String[] args) {

    }
    /**
     * 利用图的广度优先搜索算法，搜索完一个，就算一个岛屿。
     * 广度优先，使用队列来实现
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        //定义结果
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] != '1'){
                    continue;
                }
                //找到了一个新的岛屿，结果加1
                result++;
                //进行dfs遍历
                dfs(grid, i, j);
            }
        }
        return result;
    }

    /**
     * 注意这里可以叫做，先污染后治理。先不管漫步满足，放进去再说。再判断这个点是否满足条件
     * @param grid
     * @param x
     * @param y
     */
    public void dfs(char[][] grid, int x, int y){
        //判断是否在格子里面
        if (!isInArea(grid, x, y)){
            return;
        }
        //如果不是岛屿，直接返回
        if (grid[x][y] != '1'){
            return;
        }
        //把格子标记为已访问
        grid[x][y] = '2';
        //访问当前格子的上下左右
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
    //判断是否在网格里面
    public boolean isInArea(char[][] grid, int x, int y){
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            return false;
        }
        return true;
    }
}
