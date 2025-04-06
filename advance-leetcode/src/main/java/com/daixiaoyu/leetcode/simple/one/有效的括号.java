package com.daixiaoyu.leetcode.simple.one;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 23:29
 **/
public class 有效的括号 {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        //用栈来对数据进行存储
        Deque<Character> deque = new LinkedBlockingDeque<>();
        //对字符串进行遍历
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                deque.push(c);
                continue;
            }
            //这里要注意栈里面为空，导致取不到栈顶，抛出空指针异常
            if (deque.size() == 0){
                return false;
            }
            char p = deque.peek();
            if(c == ')' && p == '('){
                deque.poll();
            }
            else if(c == '}' && p == '{'){
                deque.poll();
            }
            else if(c == ']' && p == '['){
                deque.poll();
            }
            else{
                return false;
            }
        }
        //遍历结束后，判断栈里面是否为空
        if (deque.size() == 0){
            return true;
        }
        return false;
    }
}
