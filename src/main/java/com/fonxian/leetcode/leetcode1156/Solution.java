package com.fonxian.leetcode.leetcode1156;

/**
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * text = "ababa"   3
 * text = "aaabaaa" 6
 * text = "aaabbaaa" 4
 * text = "aaaaa" 5
 * text = "abcdef" 1
 *
 * @author Michael Fang
 * @since 2019-08-11
 */
public class Solution {

    public int maxRepOpt1(String text) {
        char[] charArray = text.toCharArray();
        int maxLen = 0;
        char currentChar = '\0';
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != currentChar) {
                currentChar = charArray[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String text = "ababa";//3
        text = "aaaaabbb";
        Solution solution = new Solution();
        System.out.println(solution.maxRepOpt1(text));
    }

}
