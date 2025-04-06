package com.daixiaoyu.leetcode.todo.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-01 22:13
 **/
public class 无重复字符的最长子串 {
    /**
     * @author: water76016
     * @createTime: 2025年04月01 22:39:05
     * @description: todo:用滑动窗口来做
     * @param: s
     * @return: int
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        //记录最大结果
        int result = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while (set.contains(c)){
                //如果包含的话，就要把left位置的那个字符从集合里面移出来
                char cur = s.charAt(left);
                set.remove(cur);
                left++;
            }
            //不包含的话，right就可以往前移动，同时每次都要更新最大值
            set.add(c);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
