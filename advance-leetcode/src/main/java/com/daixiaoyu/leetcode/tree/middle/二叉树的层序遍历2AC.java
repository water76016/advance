package com.daixiaoyu.leetcode.tree.middle;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description: 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @version: v1.0.0
 * @create: 2024-03-17 21:02
 **/
public class 二叉树的层序遍历2AC {
    /**
     * @author: water76016
     * @createTime: 2024年03月17 21:04:29
     * @description: 本质来时层次遍历，只不过每次把结果加到结果集的首位就可以了
     * @param: root
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
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
            //访问完一层后，把结果加入到结果集的首位
            result.add(0, list);
        }
        return result;
    }
}
