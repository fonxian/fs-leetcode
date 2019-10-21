package com.fonxian.leetcode.leetcode5222;

/**
 * https://leetcode-cn.com/contest/weekly-contest-158/problems/split-a-string-in-balanced-strings/
 * <p>
 * L 0 R 1
 * RLRRLLRLRL
 * 1011001010
 *
 * @author Michael Fang
 * @since 2019-10-13
 */
public class Solution {

    public int balancedStringSplit(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int rNum = 0;
        int lNum = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == 'R') {
                rNum++;
            }
            if (charArray[i] == 'L') {
                lNum++;
            }
            if (rNum == lNum) {
                count++;
                rNum = 0;
                lNum = 0;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.balancedStringSplit("LLLLRRRR"));
        System.out.println(s.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(s.balancedStringSplit("RLLLLRRRLR"));
    }

}
