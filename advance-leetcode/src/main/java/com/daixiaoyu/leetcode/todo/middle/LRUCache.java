package com.daixiaoyu.leetcode.todo.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-01 22:56
 **/
public class LRUCache {
    /**
     * 定义双向链表的数据结构
     * 1. 因为map有键值，所以链表里面也有键值
     * 2.既然是双向链表，那么就会有前一个节点pre，和后一个节点next
     */
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(){

        }

        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    //定义HashMap
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    //定义当前大小
    private int size;
    //定义容量
    private int capacity;

    //定义伪头部和伪尾部，方便处理
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        //两个节点连接起来
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        //先看节点是否存在
        DLinkedNode node = cache.get(key);
        if (node == null){
            //说明不存在，直接返回-1；
            return -1;
        }
        //把节点移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        //先判断节点是否已存在
        DLinkedNode node = cache.get(key);
        if (node == null){
            //节点不存在，要创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加到哈希表里面
            cache.put(key, newNode);
            //添加到双向链表的头部
            addToHead(newNode);
            size++;
            //判断size是否超出容量
            if (size > capacity){
                //移除尾部节点
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的那一项
                cache.remove(tail.key);
                size--;
            }
        }
        else{
            //节点存在,替换节点的值，并移动到头部
            node.value = value;
            moveToHead(node);

        }
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月04 16:33:48
     * @description: 把节点添加到头部（针对put命令，且节点不存在）
     * @param: node
     * @return: void
     */
    private void addToHead(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月04 16:34:30
     * @description: 把结点移除()
     * @param: node
     * @return: void
     */
    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月04 16:34:56
     * @description: 把节点移动到头部（针对add命令，且节点存在）
     * @param:
     * @return: void
     */
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月04 16:36:30
     * @description: 移除尾部节点（针对节点太多了的情况）
     * @param:
     * @return: com.daixiaoyu.leetcode.middle.one.LRUCache.DLinkedNode
     */
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
