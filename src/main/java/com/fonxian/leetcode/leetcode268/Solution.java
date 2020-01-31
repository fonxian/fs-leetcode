package com.fonxian.leetcode.leetcode268;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/missing-number/submissions/
 *
 * 因为只缺失一个数，可以将1-n所有数相加，最后减去数组中的所有数，得到的数为缺失的数
 *
 * @author Michael Fang
 * @since 2020-01-31
 */
public class Solution {


    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int res = (1 + len) * len / 2;
        for (int i = 0; i < len; i++) {
            res -= nums[i];
        }
        return res;
    }

    /**
     * 非最优解
     *
     * @param nums
     * @return
     */
    public static int missingNumberNone(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        int max = 1;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i <= max + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
