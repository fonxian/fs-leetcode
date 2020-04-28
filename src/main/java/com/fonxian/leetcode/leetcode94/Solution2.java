package com.fonxian.leetcode.leetcode94;

import com.fonxian.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用迭代的方式来解
 *
 * 莫里斯遍历
 *
 * 缺点是改变树的结构，优点是没有用辅助空间
 *
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author Michael Fang
 * @since 2020-04-12
 */
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        TreeNode pre = null;
        while(root!=null) {
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if(root.left!=null) {
                pre = root.left;
                while(pre.right!=null) {
                    pre = pre.right;
                }
                pre.right = root;
                //将root指向root的left
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                //左子树为空，则打印这个节点，并向右边遍历
            } else {
                rst.add(root.val);
                root = root.right;
            }
        }

        return rst;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node3;
        node3.left = node6;

        node2.left = node4;
        node2.right = node5;

        new Solution3().inorderTraversal(root).forEach(x -> {
            System.out.println(x);
        });
    }


}
