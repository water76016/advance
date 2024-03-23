package com.daixiaoyu.leetcode.tree.middle;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 * @version: v1.0.0
 * @create: 2024-03-17 20:16
 **/
public class 二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        midorder(root, result);
        return result.get(k - 1);
    }

    public void midorder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        midorder(root.left, result);
        result.add(root.val);
        midorder(root.right, result);
    }


}
