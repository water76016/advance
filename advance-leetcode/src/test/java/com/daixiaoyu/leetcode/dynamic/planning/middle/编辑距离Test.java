package com.daixiaoyu.leetcode.dynamic.planning.middle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 编辑距离Test {
    编辑距离 main = new 编辑距离();

    @Test
    void minDistance() {
        String word1 = "horse";
        String word2 = "ros";
        int actual = main.minDistance(word1, word2);
        assertEquals(3, actual);
    }

    @Test
    void minDistance2(){
        String word1 = "intention";
        String word2 = "execution";
        int actual = main.minDistance(word1, word2);
        assertEquals(5, actual);
    }
}