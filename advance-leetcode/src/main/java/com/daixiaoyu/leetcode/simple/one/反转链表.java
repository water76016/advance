package com.daixiaoyu.leetcode.simple.one;

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
        //定义cur节点，指向当前节点
        ListNode cur = head;
        //定义一个pre节点，指向前一个
        ListNode pre = null;
        while (cur != null){
            //定义新的next节点，保存cur.next的位置
            ListNode next = cur.next;
            //把cur.next指向pre
            cur.next = pre;
            //修改pre和cur的值
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
