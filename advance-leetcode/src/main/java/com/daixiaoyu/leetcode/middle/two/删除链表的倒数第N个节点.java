package com.daixiaoyu.leetcode.middle.two;

import com.daixiaoyu.leetcode.entity.ListNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-10 22:37
 **/
public class 删除链表的倒数第N个节点 {
    /**
     * @author: water76016
     * @createTime: 2025年04月10 22:38:17
     * @description:
     * 1.先通过快慢指针，找到倒数第N个节点
     * 2.由于删除一个节点，需要知道它的前一个节点，因此把后一个节点赋值给前一个，然后删除后一个节点即可
     * 3.注意特殊情况，链表连N个节点都没有（题目限制了，先不管）
     * @param: head
     * @param: n
     * @return: com.daixiaoyu.leetcode.entity.ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //让快指针先走N步
        int n1 = n;
        while (n1 > 0){
            fast = fast.next;
            n1--;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        if (slow == head){
            return head.next;
        }
        //注意一下特殊情况，比如链表总共刚好n个节点，删除的又是第N个节点
        if (slow.next == null){
            //如果要删除的就是最后一个节点，那没办法，只能重新再遍历一次链表
            int n2 = n;
            ListNode cur = head;
            while (cur.next.next != null){
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }
        //把后一个值赋值给前面
        int nextValue = slow.next.val;
        slow.val = nextValue;
        //删除下一个节点
        slow.next = slow.next.next;
        return head;
    }
}
