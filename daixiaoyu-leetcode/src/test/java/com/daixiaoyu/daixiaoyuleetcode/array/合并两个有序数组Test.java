package com.daixiaoyu.daixiaoyuleetcode.array;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class 合并两个有序数组Test {
    合并两个有序数组 main = new 合并两个有序数组();

    @Test
    void merge1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int[] aspect = {1, 2, 2, 3, 5, 6};
        main.merge(nums1, 3, nums2, 3);
        assertArrayEquals(aspect, nums1);
    }

    @Test
    void merge2() {
        int[] nums1 = {1};
        int[] nums2 = {};
        int[] aspect = {1};
        main.merge(nums1, 1, nums2, 0);
        assertArrayEquals(aspect, nums1);
    }

    @Test
    void merge3() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int[] aspect = {1};
        main.merge(nums1, 0, nums2, 1);
        assertArrayEquals(aspect, nums1);
    }
}