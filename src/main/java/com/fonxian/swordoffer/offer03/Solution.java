package com.fonxian.swordoffer.offer03;

/**
 *
 * 面试题03. 数组中重复的数字
 *
 找出数组中重复的数字。

 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 输入：
 [2, 3, 1, 0, 2, 5, 3]
 输出：2 或 3

 *
 * status:AC
 *
 * 面试题04. 二维数组中的查找
 *
 * @author Michael Fang
 * @since 2020-03-16
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return -1;
        }
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            if (tmp[nums[i]] == 0) {
                tmp[nums[i]] += 1;
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
