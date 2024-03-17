package com.daixiaoyu.leetcode.tree.middle;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 * 状态：已完成
 * 题解：其实就是层次遍历，只不过当需要进行锯齿的时候，将那个list的结果反转一下，放到最终的结果集里面
 * @version: v1.0.0
 * @create: 2024-03-17 16:12
 **/
public class 二叉树的锯齿形层序遍历AC {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        //标记是否需要反转的标志位
        boolean reverse = false;
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
            if (reverse){
                Collections.reverse(list);
                reverse = false;
            }
            else {
                reverse = true;
            }
            result.add(list);
        }
        return result;
    }
}
