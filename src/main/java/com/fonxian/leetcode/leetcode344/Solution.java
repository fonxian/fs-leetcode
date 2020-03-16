package com.fonxian.leetcode.leetcode344;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author Michael Fang
 * @since 2020-03-14
 */
public class Solution {

    public static void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            // a b c -> 3/2 = 1
            // a b c d -> 4 / 2 = 2
            int index = len - i - 1;
            char a1 = s[i];
            char a2 = s[index];
            s[i] = a2;
            s[index] = a1;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }


}
