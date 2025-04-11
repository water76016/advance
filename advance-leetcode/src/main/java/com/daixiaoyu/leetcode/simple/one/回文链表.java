package com.daixiaoyu.leetcode.simple.one;

import com.daixiaoyu.leetcode.entity.ListNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-03-30 22:08
 **/
public class 回文链表 {
    /**
     * @author: water76016
     * @createTime: 2025年04月07 00:38:39
     * @description: 暴力破解法，放到一个数组里面，用双指针判断
     * 好的解法。先把后面那部分链表反转，然后跟前面那部分比较
     * 比较完了之后，把后面那部分链表再反转回来
     * @param: head
     * @return: boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        //用快慢指针，找链表的中间结点
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode middle = null;
        while (fast != null){

        }
        return true;
    }
}
