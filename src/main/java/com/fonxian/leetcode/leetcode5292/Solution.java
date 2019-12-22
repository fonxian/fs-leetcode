package com.fonxian.leetcode.leetcode5292;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-168/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 * @author Michael Fang
 * @since 2019-12-22
 */
public class Solution {


    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        int[] tmp = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] == 1) {
                continue;
            }
            boolean flag = true;
            int nextNum = nums[i] + 1;
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (tmp[j] == 1) {
                    continue;
                }
                if (count == k - 1) {
                    flag = true;
                    break;
                }
                if (nums[j] > nextNum) {
                    flag = false;
                    break;
                }
                if (nums[j] == nextNum && tmp[j] != 1) {
                    tmp[j] = 1;
                    nextNum++;
                    count++;
                    continue;
                }
            }
            if (flag == false) {
                return false;
            }
            tmp[i] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
//        int[] nums = {3,3,2,2,1,1};
        int[] nums = {1,2,3,3,4,4,5,6};
        Solution solution = new Solution();
        System.out.println(solution.isPossibleDivide(nums, 4));
    }

}
