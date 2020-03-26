package com.fonxian.leetcode.leetcode5364;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
 * <p>
 * nums       index     target
 * 0            0        [0]
 * 1            1  2      [0,1]
 * 2            2  4      [0,1,2]
 * 3            2  3      [0,1,3,2]
 * 4            1  1      [0,4,1,3,2]
 *
 * @author Michael Fang
 * @since 2020-03-22
 */
public class Solution {

    public static int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] rst = new int[len];
        for (int i = 0; i < len; i++) {
            rst[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            if (rst[index[i]] == -1) {
                rst[index[i]] = nums[i];
            } else {
                int tmp = len - 1;
                while (tmp > index[i]) {
                    rst[tmp] = rst[tmp - 1];
                    tmp--;
                }
                rst[index[i]] = nums[i];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

}
