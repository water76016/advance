package com.daixiaoyu.leetcode;

import com.daixiaoyu.leetcode.entity.ListNode;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2024-03-17 16:15
 **/
public class Main {
    /**
     * @author: water76016
     * @createTime: 2025年04月07 05:38:17
     * @description: 用map来做
     * @param: s
     * @return: int
     */
    public int lengthOfLongestSubstring(String s) {
        //先判断特殊情况
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        //定义结果集
        int result = 0;
        //定义map来存储，并且去重
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                //包含的话，说明遇到了一个重复的
                //这里要取max的原因在于，如果遇到abba这种情况，start可能会跑到前面去
                start = Math.max(start, map.get(c) + 1);
            }
            //每次都要记录最大值
            result = Math.max(result, end - start + 1);
            //每次都要更新map，直接放
            map.put(c, end);
        }
        return result;
    }
}
