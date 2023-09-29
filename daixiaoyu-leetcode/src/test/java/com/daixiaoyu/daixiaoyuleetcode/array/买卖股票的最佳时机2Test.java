package com.daixiaoyu.daixiaoyuleetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 买卖股票的最佳时机2Test {
    买卖股票的最佳时机2 main = new 买卖股票的最佳时机2();

    @Test
    void maxProfit() {
        int[] nums1 = {7, 1, 5, 3, 6, 4};
        int aspect1 = main.maxProfit(nums1);
        assertEquals(7, aspect1);

        int[] nums2 = {1, 2, 3, 4, 5};
        int aspect2 = main.maxProfit(nums2);
        assertEquals(4, aspect2);

        int[] nums3 = {7, 6, 4, 3, 1};
        int aspect3 = main.maxProfit(nums3);
        assertEquals(0, aspect3);
    }
}