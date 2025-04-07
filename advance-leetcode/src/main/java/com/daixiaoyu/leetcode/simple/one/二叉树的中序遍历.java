package com.daixiaoyu.leetcode.simple.one;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-07 00:43
 **/
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        //定义结果集
        List<Integer> result = new ArrayList<>();
        orderFind(root, result);
        return result;
    }

    /**
     * 中序遍历的实际代码
     * 先遍历左子树
     * 再遍历自己
     * 最后遍历右子树
     * @param root
     * @param list
     */
    public void orderFind(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        orderFind(root.left, list);
        list.add(root.val);
        orderFind(root.right, list);
    }


}
