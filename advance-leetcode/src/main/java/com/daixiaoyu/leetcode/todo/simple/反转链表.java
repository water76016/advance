package com.daixiaoyu.leetcode.todo.simple;

import com.daixiaoyu.leetcode.entity.ListNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 22:22
 **/
//todo:
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        //定义当前节点，指向当前处理的位置
        ListNode cur = head;
        //定义前一个节点，指向当前节点的前一个
        ListNode pre = null;
        while (cur != null){
            //保存当前节点的下一个位置
            ListNode next = cur.next;
            //让当前节点指向他的前一个
            cur.next = pre;
            //更新pre和next的值
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
