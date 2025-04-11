package com.daixiaoyu.leetcode.simple.two;

import com.daixiaoyu.leetcode.entity.TreeNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-10 23:49
 **/
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        //画重点，校验空的情况
        if (root == null){
            return true;
        }
        //校验本身
        int leftDeep = maxDeep(root.left);
        int rightDeep = maxDeep(root.right);
        if (Math.abs(rightDeep - leftDeep) > 1){
            return false;
        }
        //校验子树
        if (!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }
        return true;
    }

    public int maxDeep(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }
}
