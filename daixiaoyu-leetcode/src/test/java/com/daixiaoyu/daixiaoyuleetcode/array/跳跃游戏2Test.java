package com.daixiaoyu.daixiaoyuleetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 跳跃游戏2Test {
    跳跃游戏2 main = new 跳跃游戏2();

    @Test
    void jump() {
        int[] nums1 = {2, 3, 1, 1, 4};
        int result1 = main.jump(nums1);
        assertEquals(2, result1);

        int[] nums2 = {2, 3, 0, 1, 4};
        int result2 = main.jump(nums2);
        assertEquals(2, result2);

        int[] nums3 = {1, 2};
        int result3 = main.jump(nums3);
        assertEquals(1, result3);
    }
}