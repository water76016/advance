package com.daixiaoyu.leetcode.simple.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 两数之和Test {

    @Test
    void twoSum() {
        两数之和 main = new 两数之和();
        int[] array1 = {2, 7, 11, 15};
        int[] result1 = {0, 1};
        assertArrayEquals(result1, main.twoSum(array1, 9));
    }


}