package com.fonxian.leetcode.leetcode107;

import com.fonxian.leetcode.base.TreeNode;

import java.util.*;

/**
 * @author Michael Fang
 * @since 2019-08-20
 */
public class Solution {

    @SuppressWarnings("all")
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

    }

}
