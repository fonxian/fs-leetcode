package com.fonxian.toutiao.toutiao53;

/**
 *
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * @author Michael Fang
 * @since 2020-04-12
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        return (1+len)*len/2 - sum;
    }

}
