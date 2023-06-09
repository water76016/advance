package simple.tree;

import entity.TreeNode;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * @version: v1.0.0
 * @create: 2023-07-03 00:59
 **/
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
