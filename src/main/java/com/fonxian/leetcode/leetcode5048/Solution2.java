package com.fonxian.leetcode.leetcode5048;


import java.util.Arrays;

/**
 * @author Michael Fang
 * @since 2019-08-24
 */
public class Solution2 {

    public int countCharacters(String[] words, String chars) {
        int[] charLib = new int[26];
        int res = 0;
        for (Character character : chars.toCharArray()) {
            charLib[character - 'a']++;
        }
        OK:
        for (String word : words) {
            int len = word.length();
            if (len > chars.length()) {
                continue;
            }
            int[] wordLib = Arrays.copyOf(charLib, 26);
            for (Character character:word.toCharArray()){
                if(--wordLib[character - 'a'] <0){
                    continue OK;
                }
            }
            res += len;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(solution2.countCharacters(words, chars));
    }

}
