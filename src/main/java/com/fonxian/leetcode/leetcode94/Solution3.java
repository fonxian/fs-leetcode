package com.fonxian.leetcode.leetcode94;

import com.fonxian.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代遍历
 *
 * @author Michael Fang
 * @since 2020-04-12
 */
public class Solution3 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() != 0) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                rst.add(tmp.val);
                root = tmp.right;
            }
        }

        return rst;

    }

}
