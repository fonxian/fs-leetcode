package com.fonxian.leetcode.leetcode94;

import com.fonxian.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author Michael Fang
 * @since 2020-04-12
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        traversal(root, rst);

        return rst;

    }

    /**
     * 使用递归的思路来解
     * @param node
     * @param rst
     */
    public void traversal(TreeNode node, List<Integer> rst) {
        if (node == null) {
            return;
        }
        traversal(node.left, rst);
        rst.add(node.val);
        traversal(node.right, rst);
    }



}
