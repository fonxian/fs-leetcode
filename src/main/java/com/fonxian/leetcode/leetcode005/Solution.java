package com.fonxian.leetcode.leetcode005;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author Michael Fang
 * @since 2020-03-27
 */
public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        // babad
        String rst = "";
        boolean[][] dp = new boolean[len][len];
        // dp[i][j] = dp[i+1][j-1] & s[i] = s[j]
        // init
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (i >= j) {
                    continue;
                }
                if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && j - i + 1 > rst.length()) {
                    rst = s.substring(i, j + 1);
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }

}
