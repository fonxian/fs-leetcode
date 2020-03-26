package com.fonxian.leetcode.leetcode136;

/**
 * https://leetcode-cn.com/problems/single-number/
 *
 * 136. 只出现一次的数字
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-21
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int rst = 0;
        for(int num:nums){
            rst = rst ^ num;
        }
        return rst;
    }

}
