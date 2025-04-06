package com.daixiaoyu.leetcode.simple.one;

import com.daixiaoyu.leetcode.entity.ListNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-04 23:08
 **/
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //先对特殊情况进行判断
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        //定义结果指针
        ListNode result = new ListNode();
        ListNode reIndex = result;
        //定义两个指针
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                reIndex.next = cur1;
                cur1 = cur1.next;
            }
            else {
                reIndex.next = cur2;
                cur2 = cur2.next;
            }
            reIndex = reIndex.next;
        }
        //最后把非空的那个链表，链在后面
        if (cur1 != null){
            reIndex.next = cur1;
        }
        else {
            reIndex.next = cur2;
        }
        return result.next;
    }
}
