package com.fonxian.leetcode.leetcode5174;

/**
 * https://leetcode-cn.com/contest/weekly-contest-152/problems/diet-plan-performance/
 *
 * @author Michael Fang
 * @since 2019-09-01
 */
public class Solution {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int res = 0;
        int len = calories.length;
        OK:
        for (int i = 0; i < len; i++) {
            int sum = 0;
            if (i + k > len) {
                continue OK;
            }
            for (int j = 0; j < k; j++) {
                sum += calories[i + j];
            }
            if (sum > upper) {
                res++;
            }
            if (sum < lower) {
                res--;
            }

        }
        return res;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        //        int[] calories = {6, 5, 0, 0};
//        System.out.println(solution.dietPlanPerformance(calories, 2, 1, 5));
//
//        int[] calories = {3, 2};
//        System.out.println(solution.dietPlanPerformance(calories, 2, 0, 1));

        int[] calories = {6, 13, 8, 7, 10, 1, 12, 11};
        System.out.println(solution.dietPlanPerformance(calories, 6, 5, 37));

    }
}
