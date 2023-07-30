package middle.link;

import entity.ListNode;

/**
 * @program: advance
 * @author: water76016
 * @description:将一个链表L0.L1...LN-1.LN变成L0.LN.L1.LN-1...这种形式
 * //方法1：使用列表来存储每个节点，然后在列表里面访问每个元素，实现重排，时间和空间复杂度都是O（N）
 * //方法2：寻找链表中点 + 链表逆序 + 两个链表重新组合
 * 寻找链表中点：使用快慢指针
 * @version: v1.0.0
 * @create: 2023-07-30 15:10
 **/
class 重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时慢节点走到了中间的位置
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
