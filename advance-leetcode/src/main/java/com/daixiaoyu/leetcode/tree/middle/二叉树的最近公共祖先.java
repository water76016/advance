package com.daixiaoyu.leetcode.tree.middle;

import com.daixiaoyu.leetcode.entity.TreeNode;

import java.util.List;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @version: v1.0.0
 * @create: 2024-03-17 16:33
 **/
public class 二叉树的最近公共祖先 {
    /**
     * @author: water76016
     * @createTime: 2024年03月17 16:35:09
     * @description: 自己的答案：
     * 对于分别找到两个节点，会对应两条路径，针对路径的话，需要使用深度优先遍历
     * 两条路径取交集，路径的最后那个交点，就是最近的公共祖先
     * @param: root
     * @param: p
     * @param: q
     * @return: com.daixiaoyu.leetcode.entity.TreeNode
     */
    public TreeNode lowestCommonAncestor_self(TreeNode root, TreeNode p, TreeNode q) {
        //先对特殊值进行判断
        if (root == null){
            return null;
        }
        List<TreeNode> pathP = dfs(root, p);
        List<TreeNode> pathQ = dfs(root, q);
        TreeNode result = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++){
            if (pathP.get(i) == pathQ.get(i)){
                result = pathP.get(i);
            }
            else {
                break;
            }
        }
        return result;
    }
    /**
     * @author: water76016
     * @createTime: 2024年03月17 16:38:35
     * @description: 找到node节点的路径.
     * 针对路径的话，
     * @param: root
     * @param: node
     * @return: java.util.List<com.daixiaoyu.leetcode.entity.TreeNode>
     */
    public List<TreeNode> dfs(TreeNode root, TreeNode node){
        return null;
    }

    //-------------------------------------------------------------------------------------------------//
    //下面是比较好的解答
    /**
     * @author: water76016
     * @createTime: 2024年03月17 16:52:17
     * @description:针对这道题，可能会有以下几种情况：
     * 1.如果p或者q其中一个是根节点的话，那么他们的最近祖先就是根节点，直接返回
     * 2.如果p或者q两个都在根节点的左边的话，那么最近祖先也会在根节点的左边
     * 3.如果p或者q两个都在根节点的右边的话，那么最近祖先也会在根节点的右边
     * 4.如果p或者q一个在根节点的左边，一个在根节点的右边的话，那么最近祖先也就是根节点，直接返回
     * @param: root
     * @param: p
     * @param: q
     * @return: com.daixiaoyu.leetcode.entity.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        //判断p或者q其中一个是否是根节点
        if (p == root || q == root){
            return root;
        }
        //判断p或者q是否都在根节点的左边或者是右边
        if (findNode(root.left, p) && findNode(root.left, q)){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (findNode(root.right, p) && findNode(root.right, q)){
            return lowestCommonAncestor(root.right, p, q);
        }
        //p和q分别在根节点的左右两侧，直接返回根节点
        return root;
    }
    /**
     * @author: water76016
     * @createTime: 2024年03月17 17:03:07
     * @description: 判断node是否在root这棵子树下面
     * @param:
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
