package com.fonxian.leetcode.leetcode046;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2020-04-29
 */
public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(res, nums, used, path, len, 0);
        return res;


    }

    public void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path, int len, int dept) {

        // 终止条件
        if (dept == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {

                used[i] = true;
                path.add(nums[i]);
                dept++;

                dfs(res, nums, used, path, len, dept);

                used[i] = false;
                path.remove(path.size() - 1);
                dept--;

            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution2 solution = new Solution2();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
