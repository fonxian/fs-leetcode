package com.fonxian.leetcode.leetcode046;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/permutations/
 *
 * 使用回溯算法
 *
 * what
 *
 * 回溯：指的是状态，回到过去、恢复现场
 *
 * 回溯是深度优先特有的一种现象。从深节点到浅节点的过程叫回溯。
 *
 *
 *
 *
 *
 * @author Michael Fang
 * @since 2020-04-28
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        // 最大的深度取决于有多少个数
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        // 为什么要用递归？
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {

        // 终止条件：数选够了，也就是达到了最大深度
        if (depth == len) {
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }


}
