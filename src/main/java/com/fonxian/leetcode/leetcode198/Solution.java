package com.fonxian.leetcode.leetcode198;

/**
 * https://leetcode-cn.com/problems/house-robber/
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-14
 */
public class Solution {

    public static int rob(int[] nums) {
        // dp[i] = max(i + dp[i-2],dp[i-1])
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = dp[0];
        // 考虑[2,1,1,2]这种情况
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }

}
