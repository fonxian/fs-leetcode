package com.fonxian.leetcode.leetcode5344;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-178/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * @author Michael Fang
 * @since 2020-03-01
 */
public class Solution {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {8, 1, 2, 2, 3};
        int[] nums = {6,5,4,8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

}
