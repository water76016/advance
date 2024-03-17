package com.daixiaoyu.leetcode.tree.simple;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2024-03-17 20:02
 **/
public class 二叉树某个节点到根节点的路径自己实现的 {
    public String findPath(TreeNode root, Integer value){
        List<String> result = new ArrayList<>();
        findPath(root, "", result, value);
        if (result.isEmpty()){
            return "";
        }
        return result.get(0);
    }
    public void findPath(TreeNode root, String path, List<String> result, Integer value){
        //当节点为根节点，或者列表里面有一个结果，说明可以退出了
        if (root == null || result.size() > 0){
            return;
        }
        StringBuilder curPath = new StringBuilder(path);
        curPath.append(value);
        if (root.val == value){
            result.add(curPath.toString());
            return;
        }
        curPath.append("->");
        findPath(root.left, curPath.toString(), result, value);
        findPath(root.right, curPath.toString(), result, value);
    }
}
