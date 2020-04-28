package com.fonxian.leetcode.leetcode280;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/wiggle-sort/
 *
 * @author Michael Fang
 * @since 2020-04-01
 */
public class Solution {

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < len - 1; i = i + 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
