package com.daixiaoyu.leetcode.middle.two;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-11 20:02
 **/
public class 单词搜索 {


    public static void main(String[] args) {
        单词搜索 dd = new 单词搜索();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(dd.exist(board, "ABCB"));
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月11 20:41:21
     * @description: 这道题也是按照dfs进行搜索即可，不过要注意左右来回搜索的情况，所以要设置visit标记是否访问过
     * @param: board
     * @param: word
     * @return: boolean
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == word.charAt(0)){
                    boolean flag = dfs(board, word, i, j, 0, visited);
                    if (flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int cur, boolean[][] visited){
        //先判断是否满足范围
        int m = board.length;
        int n = board[0].length;
        //判断是否已经遍历完了
        if (cur >= word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n){
            return false;
        }
        //如果不相等，或者已经被访问过，则置为false
        if (board[i][j] != word.charAt(cur) || visited[i][j]){
            return false;
        }
        //进来的时候置为true
        visited[i][j] = true;
        //到这了就是满足当前值，但要搜索下一个
        boolean one = dfs(board, word, i - 1, j, cur + 1, visited);
        boolean two = dfs(board, word, i + 1, j, cur + 1, visited);
        boolean three = dfs(board, word, i, j - 1, cur + 1, visited);
        boolean four = dfs(board, word, i, j + 1, cur + 1, visited);
        //出去的时候置为false
        visited[i][j] = false;
        return one || two || three || four;
    }
}
