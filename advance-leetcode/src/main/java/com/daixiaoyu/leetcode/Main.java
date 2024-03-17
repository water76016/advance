package com.daixiaoyu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2024-03-17 16:15
 **/
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());

        Collections.reverse(list);
        System.out.println(list.toString());
    }
}
