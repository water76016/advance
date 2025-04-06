package com.daixiaoyu.leetcode.todo.simple;

import com.daixiaoyu.leetcode.entity.ListNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-31 22:19
 **/
public class 相交链表 {
    //todo:这里没有一次过的原因在于while的判断，只要有一个不为空，整个循环都应该进行下去，所以是或关系
    /**
     * @author: water76016
     * @createTime: 2025年03月31 22:27:32
     * @description: 设A的长度是a + b ，设B的长度是c + b。
     * 那么只需要两者走相同的长度，那么最后的终点，要么是null
     * 要么是相交点
     * @param: headA
     * @param: headB
     * @return: com.daixiaoyu.leetcode.entity.ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null || curB != null){
            if (curA == curB){
                return curA;
            }
            if (curA == null){
                curA = headB;
            }
            else {
                curA = curA.next;
            }
            if (curB == null){
                curB = headA;
            }
            else {
                curB = curB.next;
            }
        }
        return null;
    }
}
