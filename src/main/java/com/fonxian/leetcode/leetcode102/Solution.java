package com.fonxian.leetcode.leetcode102;

import com.alibaba.fastjson.JSONObject;
import com.fonxian.leetcode.base.TreeNode;

import java.util.*;

/**
 *
 * status: pass
 * @author Michael Fang
 * @since 2019-08-20
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(3);
        TreeNode node11 = new TreeNode(9);
        TreeNode node12 = new TreeNode(20);
        TreeNode node21 = new TreeNode(15);
        TreeNode node22 = new TreeNode(7);
        node1.left = node11;
        node1.right = node12;
        node12.left = node21;
        node12.right = node22;
        List<List<Integer>> list = solution.levelOrder(node1);
        Collections.reverse(list);
        System.out.println(JSONObject.toJSONString(list));


    }
}
