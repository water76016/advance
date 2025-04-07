package com.daixiaoyu.leetcode.todo.middle;

import com.daixiaoyu.leetcode.entity.TreeNode;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 23:37
 **/
public class 二叉树的最近公共祖先 {
    /**
     * @author: water76016
     * @createTime: 2025年04月06 23:39:17
     * @description: 在最近公共祖先这个问题上，会存在几种情况：
     * 1. 如果两个就节点中，有一个等于当前节点，那么直接返回当前节点
     * 2.如果两个节点在当前节点的左子树中，从当前节点的左子树中找
     * 3.如果两个节点在当前节点的右子树中，从当前节点的右子树中找
     * 4.两个节点分别在两边，直接放回当前节点
     * @param: root
     * @param: p
     * @param: q
     * @return: com.daixiaoyu.leetcode.entity.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        //看看左边节点能不能找到目标值
        if (findNode(root.left, p) && findNode(root.left, q)){
            return lowestCommonAncestor(root.left, p, q);
        }
        //看看右边节点能不能找到目标值
        if (findNode(root.right, p) && findNode(root.right, q)){
            return lowestCommonAncestor(root.right, p, q);
        }
        //都没找到的话，说明两个节点分别属于左右子树，直接返回当前节点
        return root;
    }
    /**
     * @author: water76016
     * @createTime: 2025年04月06 23:57:52
     * @description: 判断某个节点是否在某个子树里面
     * @param: root
     * @param: node
     * @return: boolean
     */
    public boolean findNode(TreeNode root, TreeNode node){
        if (root == node){
            return true;
        }
        if (root != null){
            return findNode(root.left, node) || findNode(root.right, node);
        }
        return false;

    }

}
