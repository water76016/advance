package com.daixiaoyu.leetcode.tree.simple;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @version: v1.0.0
 * @create: 2024-03-17 20:42
 **/
public class 二叉树的中序遍历AC {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
