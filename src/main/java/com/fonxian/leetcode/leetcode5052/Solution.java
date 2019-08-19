package com.fonxian.leetcode.leetcode5052;

import com.fonxian.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Michael Fang
 * @since 2019-08-18
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("invalid parameters");
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 0;
        int sum = 0;
        //当队列不是空的时候，将队列头移除，将其儿子节点加入队列
        int ceng = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();//记录当前层节点的个数
            TreeNode temp;
            int result = 0;
            //遍历size次
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                result += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            if (result > sum) {
                index = ceng;
                sum = result;
            }
            ceng++;
        }
        return index;
    }

    public static void main(String[] args) {


        TreeNode node1 = new TreeNode(989);
        TreeNode node11 = new TreeNode(10250);
        TreeNode node12 = new TreeNode(98693);
        TreeNode node21 = new TreeNode(-89388);
        TreeNode node22 = new TreeNode(-32127);

        node1.left = node11;
        node1.right = node12;

        node11.left = node21;
        node11.right = node22;

        Solution s = new Solution();
        System.out.println(s.maxLevelSum(node1));


    }

}
