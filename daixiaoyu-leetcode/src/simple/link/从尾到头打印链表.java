package simple.link;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance
 * @author: water76016
 * @description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @version: v1.0.0
 * @create: 2023-07-27 22:28
 **/
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        List<Integer> save = new ArrayList<>();
        saveValue(save, head);
        return save.stream().mapToInt(i -> i).toArray();
    }

    public void saveValue(List<Integer> save, ListNode node){
        if(node.next != null){
            saveValue(save, node.next);
        }
        save.add(node.val);
    }
}
