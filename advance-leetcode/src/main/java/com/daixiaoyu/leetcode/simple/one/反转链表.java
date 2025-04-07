package com.daixiaoyu.leetcode.simple.one;

import com.daixiaoyu.leetcode.entity.ListNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 22:22
 **/
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        //先检查特殊情况
        if (head == null || head.next == null){
            return head;
        }
        //定义cur指针，指向当前位置
        ListNode cur = head;
        //定义pre指针，指向前一个位置（初始化为null）
        ListNode pre = null;
        while (cur != null){
            //先把下一个位置给保存起来
            ListNode next = cur.next;
            //当前位置指向前一个位置
            cur.next = pre;
            //更新pre
            pre = cur;
            //更新cur
            cur = next;
        }
        return pre;
    }
}
