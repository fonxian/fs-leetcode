package com.fonxian.leetcode.leetcode1283;

/**
 * https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/
 *
 * 使用二分的思想解题
 *
 * @author Michael Fang
 * @since 2019-12-08
 */
public class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int maxVal = 1;
        for(int i = 0;i<nums.length;i++){
            maxVal = Math.max(maxVal,nums[i]);
        }
        int lo = 1;
        int hi = maxVal;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int res = cal(nums, mid);
            if (res > threshold) lo = mid + 1;
            else hi = mid;

        }
        return lo;
    }

    private int cal(int[] nums, int div) {
        int sum = 0;
        for (int n : nums) {
            sum += n / div;
            // 向上取整
            if (n % div != 0) sum += 1;
        }
        return sum;
    }

}
