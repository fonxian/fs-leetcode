package com.fonxian.leetcode.leetcode5346;

/**
 * @author Michael Fang
 * @since 2020-03-01
 */
public class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        return false;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

    }

}
