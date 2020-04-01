package com.fonxian.leetcode.leetcode101;

import com.fonxian.leetcode.base.TreeNode;


/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author Michael Fang
 * @since 2019-08-20
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return (root1.val == root2.val) && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);

    }



}
