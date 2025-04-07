package com.daixiaoyu.leetcode.simple.one;

import com.daixiaoyu.leetcode.entity.ListNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-07 00:08
 **/
public class 环形链表 {
    /**
     * @author: water76016
     * @createTime: 2025年04月07 00:08:38
     * @description: 用快慢指针来做
     * @param: head
     * @return: boolean
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null){
            if (slow == fast){
                //找到环了，结束
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
