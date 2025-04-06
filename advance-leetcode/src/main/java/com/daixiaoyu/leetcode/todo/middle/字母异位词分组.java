package com.daixiaoyu.leetcode.todo.middle;

import java.util.*;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 20:50
 **/
public class 字母异位词分组 {
    /**
     * @author: water76016
     * @createTime: 2025年03月30 20:51:15
     * @description: 把每个字符串，弄成a1b2c3这样，这样就能把字符串分组了
     * @param: strs
     * @return: java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //用来存储分组的结果
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            String reverStr = reverseString(str);
            //如果map中存在，则放到map里面去
            if (map.containsKey(reverStr)){
                map.get(reverStr).add(str);
            }
            else {
                //如果map中不存在，则new一个list出来
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(reverStr, list);
            }
        }
        //收集结果
        List<List<String>> result = new ArrayList<>();
        for (List<String> value : map.values()){
            result.add(value);
        }
        return result;
    }
    /**
     * @author: water76016
     * @createTime: 2025年03月30 20:52:10
     * @description: 转换字符串的统一格式
     * @param:
     * @return: java.lang.String
     */
    public String reverseString(String str){
        //仅包含小写字母，那么弄一个26长度的数组就行
        int[] save = new int[26];
        for (char c : str.toCharArray()){
            save[c - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < save.length; i++){
            char cur = (char)(i + 'a');
            stringBuilder.append(cur).append(save[i]);
        }
        return stringBuilder.toString();
    }
}
