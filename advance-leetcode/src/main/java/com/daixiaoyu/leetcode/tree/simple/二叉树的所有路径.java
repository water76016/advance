package com.daixiaoyu.leetcode.tree.simple;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description: 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * @version: v1.0.0
 * @create: 2024-03-17 19:40
 **/
public class 二叉树的所有路径 {
    /**
     * @author: water76016
     * @createTime: 2024年03月17 19:42:08
     * @description: 使用dfs，不断地往下遍历，使用stringbuilder来存储中间路径，
     * 如果当前访问到的节点是叶子节点，则找到一个结果，加入到结果集里面
     * 如果是非叶子节点，则加入到路径里面，继续往下进行遍历
     * @param: root
     * @return: java.util.List<java.lang.String>
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        findPath(root, "", result);
        return result;
    }

    public void findPath(TreeNode root, String path, List<String> result){
        if (root == null){
            return;
        }
        StringBuilder curPath = new StringBuilder(path);
        curPath.append(root.val);
        if (root.left == null && root.right == null){
            //当前节点是叶子节点，可以收集到结果集里面
            result.add(curPath.toString());
        }
        else {
            curPath.append("->");
            findPath(root.left, curPath.toString(), result);
            findPath(root.right, curPath.toString(), result);
        }
    }
}
