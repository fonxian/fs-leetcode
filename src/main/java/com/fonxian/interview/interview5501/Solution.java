package com.fonxian.interview.interview5501;

import com.fonxian.base.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *

 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

 例如：

 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。


 status:AC

 * @author Michael Fang
 * @since 2020-03-20
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        int rst = 0;
        if(root == null){
            return rst;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(queue.size() != 0){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            rst++;
        }
        return rst;
    }

}
