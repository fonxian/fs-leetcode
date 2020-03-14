package com.fonxian.leetcode.leetcode053;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-14
 */
public class Solution {

    public static int maxSubArray(int[] nums) {
        // dp[i] = max(dp[i-1]+nums[i],nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

}
