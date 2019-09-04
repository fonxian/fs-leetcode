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

    char[] charArray = null;
    int len = 0;

    public int maxRepOpt1(String text) {

        int res = 0;
        charArray = text.toCharArray();
        len = charArray.length;
        //覆盖第一种情况
        // 全部为1种字符
        //中间包含1种其他字符
        //中间包含2种其他字符
        for (int i = 0; i < len; i++) {
            int curCount = 1;
            boolean change = true;
            char curChar = charArray[i];
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (charArray[j] == curChar) {
                    curCount++;
                } else if ((j + 1) < len && charArray[j + 1] == curChar && change && existMoreChar(curChar, i, j + 1)) {
                    change = false;
                    curCount++;
                } else {
                    break;
                }
                index = j;
            }
            if (change && existMoreChar(curChar, i, index)) {
                curCount++;
            }
            if (curCount > res) {
                res = curCount;
            }
        }

        return res;
    }

    private boolean existMoreChar(char curChar, int i, int j) {
        for (int k = j + 1; k < charArray.length; k++) {
            if (charArray[k] == curChar) {
                return true;
            }
        }
        for (int k = 0; k < i; k++) {
            if (charArray[k] == curChar) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "ababa";//3
        text = "aaaaabbb"; //5

//        text = "aaaba"; //4
//        text = "aaabbaaa"; //4
//        text = "aaabbaaaa"; //5
//        text = "abcdef"; //1
//        text = "aaaaa"; //5
//        text = "bbababaaaa";//6
        //        text = "aaabaaa"; //6
        Solution solution = new Solution();
        System.out.println(solution.maxRepOpt1(text));
    }

}
