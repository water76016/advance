package com.daixiaoyu.daixiaoyuleetcode.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class 移除元素Test {
    移除元素 main = new 移除元素();
    @Test
    void removeElement1() {
        int[] nums = {3, 2, 2, 3};
        int actual = main.removeElement(nums, 3);
        assertEquals(2, actual);
    }
    @Test
    void removeElement2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int actual = main.removeElement(nums, 2);
        assertEquals(5, actual);
    }
}