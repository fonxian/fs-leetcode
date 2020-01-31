package com.fonxian.leetcode.leetcode66;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/submissions/
 * <p>
 * 注意999这种情况，需要新创建一个数组
 *
 * @author Michael Fang
 * @since 2020-01-31
 */
public class Solution {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int tmp = len;
        while (tmp > 0) {
            if (digits[tmp - 1] + 1 < 10) {
                digits[tmp - 1] = digits[tmp - 1] + 1;
                break;
            } else {
                digits[tmp - 1] = 0;
                if (tmp == 1) {
                    int[] res = new int[len + 1];
                    res[0] = 1;
                    System.arraycopy(res, 1, digits, 0, len);
                    return res;
                }
            }
            tmp--;
        }
        return digits;
    }

    public static void main(String[] args) {
//        int[] digits = {4, 3, 9, 9};
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

}
