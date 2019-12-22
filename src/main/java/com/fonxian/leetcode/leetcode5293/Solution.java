package com.fonxian.leetcode.leetcode5293;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/weekly-contest-168/problems/maximum-number-of-occurrences-of-a-substring/
 *
 * @author Michael Fang
 * @since 2019-12-22
 */
public class Solution {


    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        Map<String, Integer> resMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= len - minSize; i++) {
            String subStr = s.substring(i, i + minSize);
            if (getNotReaptCharacterNum(subStr) <= maxLetters) {
                Integer count = resMap.get(subStr);
                if (count == null) {
                    resMap.put(subStr, 1);
                    count = 0;
                } else {
                    resMap.put(subStr, count + 1);
                }
                if (count + 1 > res) {
                    res = count + 1;
                }
            }
        }
        return res;
    }

    private int getNotReaptCharacterNum(String subStr) {
        Set<Character> set = new HashSet<>();
        char[] chars = subStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

//        String s = "aababcaab";
//        int res = solution.maxFreq(s, 2, 3, 4);

//        String s = "aaaa";
//        int res = solution.maxFreq(s, 1, 3, 3);

        String s = "aabcabcab";
        int res = solution.maxFreq(s, 2, 2, 3);

        System.out.println(res);
    }

}
