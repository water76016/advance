package com.daixiaoyu.leetcode.middle.one;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 10:39
 **/
public class 二叉树的层次遍历 {
    /**
     * @author: water76016
     * @createTime: 2025年04月06 10:40:19
     * @description: 层次遍历需要用队列来做
     * @param: root
     * @return: List<List<Integer>>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //层次遍历用队列来存储
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        //定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (queue.size() > 0){
            //获取当前层的大小
            int curSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < curSize; i++){
                TreeNode node = queue.poll();
                //把当前层的下一级放到队列里面去
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            //收集当前层的结果
            result.add(list);
        }
        return result;
    }
}
