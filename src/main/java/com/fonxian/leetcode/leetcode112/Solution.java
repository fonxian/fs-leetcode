package com.fonxian.leetcode.leetcode112;

import com.fonxian.base.tree.TreeNode;

/**
 *
 * https://leetcode-cn.com/problems/path-sum/submissions/
 *
 * @author Michael Fang
 * @since 2020-03-29
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null){
            return false;
        }
        sum -= root.val;
        if(root.left == null && root.right == null){
            return sum == 0;
        }

        return hasPathSum(root.right,sum) || hasPathSum(root.left,sum);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
    }

}
