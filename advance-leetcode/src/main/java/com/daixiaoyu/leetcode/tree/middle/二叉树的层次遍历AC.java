package com.daixiaoyu.leetcode.tree.middle;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 * 状态：已完成
 * 题解：
 * 二叉树的层次遍历也就是图的层次遍历，对于层次遍历是使用广度优先搜索实现的，
 * 广度优先搜索的话，又是需要用到队列来做
 * @version: v1.0.0
 * @create: 2024-03-17 15:31
 **/
public class 二叉树的层次遍历AC {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            //访问完一层后，把结果加入到结果集里面
            result.add(list);
        }
        return result;
    }
}
