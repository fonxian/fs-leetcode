package com.fonxian.leetcode.leetcode5291;

/**
 * https://leetcode-cn.com/contest/weekly-contest-168/problems/find-numbers-with-even-number-of-digits/
 *
 * @author Michael Fang
 * @since 2019-12-22
 */
public class Solution {

    public int findNumbers(int[] nums) {
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            if(String.valueOf(nums[i]).length() % 2 == 0){
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {12, 345, 2, 6, 7896};
        int[] nums = {555,901,482,1771};
        Solution solution = new Solution();
        System.out.println(solution.findNumbers(nums));
    }

}
