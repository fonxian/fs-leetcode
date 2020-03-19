package com.fonxian.interview.interview56;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-20
 */
public class Solution {

    public static int[] singleNumbers(int[] nums) {
        // 4 1 4 6
        int[] rst = new int[2];
        int len = nums.length;
        if (len == 2) {
            return nums;
        }
        // 获取出现过1次的两个数相与后的中间值mid = a1 ^ a2
        int mid = 0;
        for (int num : nums) {
            mid = mid ^ num;
        }
        // 获取mid中最低位1对应的数值mask
        int mask = mid & (mid * (-1));
        for (int num : nums) {
            if ((num & mask) == 0) {
                rst[0] ^= num;
            } else {
                rst[1] ^= num;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

}
