package com.daixiaoyu.leetcode.tree.simple;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @version: v1.0.0
 * @create: 2024-03-17 20:22
 **/
public class 二叉树的前序遍历AC {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
