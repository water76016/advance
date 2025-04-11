package com.daixiaoyu.leetcode.middle.two;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-09 23:36
 **/
public class 反转字符串中的单词 {
    public static void main(String[] args) {
        String res = reverseWords("the sky is blue");
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        //定义结果
        StringBuilder result = new StringBuilder();
        //要从后往前遍历
        int n = s.length();
        //定义标记位，标记是否是字符串的开始
        boolean first = true;
        //定义字符串开始的那个位置
        int end = 0;
        for (int i = n - 1; i >= 0; i--){
            char c = s.charAt(i);
            if (c == ' '){
                if (first){
                    continue;
                }
                else {
                    //遇到了一个完整的单词，可以开始收集了
                    //开始收集
                    String subString = s.substring(i + 1, end + 1);
                    if (result.length() == 0){
                        result.append(subString);
                    }
                    else {
                        result.append(" ").append(subString);
                    }
                    first = true;
                }
            }
            else {
                if (first){
                    first = false;
                    end = i;
                }
                else {
                    continue;
                }
            }
        }
        //处理最后遍历完的那种情况
        if (!first){
            String subString = s.substring(0, end + 1);
            if (result.length() == 0){
                return subString;
            }
            else {
                result.append(" ").append(subString);
            }
        }

        return result.toString();
    }
}
