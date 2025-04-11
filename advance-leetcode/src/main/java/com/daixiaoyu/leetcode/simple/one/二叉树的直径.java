package com.daixiaoyu.leetcode.simple.one;

import com.daixiaoyu.leetcode.entity.TreeNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-09 08:41
 **/
public class 二叉树的直径 {
    /**
     * @author: water76016
     * @createTime: 2025年04月09 08:41:50
     * @description: 如果这个直径需要两边子树一起，那么就是左边的最大深度 + 右边的最大深度
     * 如果这个子树不需要经过根节点，那么就是在左边或者右边
     * @param: root
     * @return: int
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int curDiameter = maxDeep(root.left) + maxDeep(root.right) + 1;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(curDiameter, Math.max(left, right));
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月09 08:43:49
     * @description: 求二叉树的最大深度
     * @param: node
     * @return: int
     */
    public int maxDeep(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftDeep = maxDeep(node.left);
        int rightDeep = maxDeep(node.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }
}
