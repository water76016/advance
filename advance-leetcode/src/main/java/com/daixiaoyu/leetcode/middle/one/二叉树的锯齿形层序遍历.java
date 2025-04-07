package com.daixiaoyu.leetcode.middle.one;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 23:32
 **/
public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        //标记是否需要反转的标志位
        boolean reverse = false;
        //声明存储的那个队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        //当队列不为空，就说明还有值没访问到，就一直访问
        while (deque.size() > 0){
            //存储当前应该访问的大小
            int curSize = deque.size();
            //存储当前访问的结果
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < curSize; i++){
                TreeNode treeNode = deque.pollLast();
                list.add(treeNode.val);
                if (treeNode.left != null){
                    deque.addFirst(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.addFirst(treeNode.right);
                }
            }
            //访问完一层后，把结果加入到结果集里面
            if (reverse){
                Collections.reverse(list);
                reverse = false;
            }
            else {
                reverse = true;
            }
            result.add(list);
        }
        return result;
    }
}
