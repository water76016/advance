package com.daixiaoyu.daixiaoyuleetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 跳跃游戏Test {
    跳跃游戏 main = new 跳跃游戏();

    @Test
    void canJump() {
        int[] nums1 = {2, 3, 1, 1, 4};
        boolean result1 = main.canJump(nums1);
        assertTrue(result1);

        int[] nums2 = {3, 2, 1, 0, 4};
        boolean result2 = main.canJump(nums2);
        assertFalse(result2);
    }
}