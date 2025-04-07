package com.daixiaoyu.leetcode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-07 05:46
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * @author: water76016
 * @createTime: 2025年04月07 05:48:00
 * @description: LRU缓存主要是使用的双向链表，所以自己要有双向链表的数据结构
 * map的作用在于，能够通过key，快速地找到这个链表的那个节点
 * 在定义的时候，定义虚拟的头结点和尾节点，那么程序就不用特殊处理了
 * @param: null
 * @return: null
 */
public class LRUCache {
    private Map<Integer, SLinkNode> map;
    private SLinkNode head;
    private SLinkNode tail;
    private int capacity;
    //记录当前大小（需要有一个数来记录的原因是：map是没有删除动作的，所以map的容量不能代替当前大小）
    private int size = 0;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new SLinkNode();
        this.tail = new SLinkNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月07 05:58:58
     * @description: get方法，如果节点不存在，直接返回-1
     * 如果节点存在，先把节点移动到head的位置，然后再进行返回
     *
     * @param: key
     * @return: int
     */
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        SLinkNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月07 06:06:01
     * @description: put的情况会稍微复杂点，分两种情况：
     * 1.如果这个值已存在。则覆盖原有的值，并把节点移到最前面
     * 2.如果这个值不存在，则把这个节点放进去，并移动到最前面，再检测是否超出容量，如果超出容量，还要把最后那个节点移出去。
     * @param: key
     * @param: value
     * @return: void
     */
    public void put(int key, int value) {
        if (map.containsKey(key)){
            SLinkNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
        else {
            size++;
            //值不存在，封装一个新的节点
            SLinkNode newNode = new SLinkNode(key, value);
            //把节点放到map里面去
            map.put(key, newNode);
            //把节点移动到最前面
            addToHead(newNode);
            //判断是否超出容量上限
            if (size > capacity){
                deleteTail();
            }
        }
    }

    public void deleteTail(){
        //删除尾部的那个节点
        SLinkNode node = tail.pre;
        deleteNode(node);
        //删除map里面那个key
        map.remove(node.key);
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月07 06:08:35
     * @description: 把一个节点移动到最前面
     * @param: node
     * @return: void
     */
    public void moveToHead(SLinkNode node){
        int key = node.key;
        int value = node.value;
        //删除原来那个节点
        deleteNode(node);
        //添加一个新的节点到头部
        addToHead(node);

    }

    public void addToHead(SLinkNode node){
        //把节点添加到头部
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void deleteNode(SLinkNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
}

class SLinkNode{
    public int key;
    public int value;
    public SLinkNode pre;
    public SLinkNode next;

    public SLinkNode(){

    }

    public SLinkNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}