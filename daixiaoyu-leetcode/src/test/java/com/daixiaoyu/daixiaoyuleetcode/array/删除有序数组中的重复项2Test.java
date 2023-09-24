package com.daixiaoyu.daixiaoyuleetcode.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class 删除有序数组中的重复项2Test {
    删除有序数组中的重复项2 main = new 删除有序数组中的重复项2();

    @Test
    void removeDuplicates1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int actual = main.removeDuplicates(nums);
        assertEquals(5, actual);
    }

    @Test
    void removeDuplicates2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int actual = main.removeDuplicates(nums);
        assertEquals(7, actual);
    }
}