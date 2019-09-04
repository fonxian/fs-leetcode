package com.fonxian.leetcode.leetcode5175;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/can-make-palindrome-from-substring/
 *
 * @author Michael Fang
 * @since 2019-09-01
 */
@SuppressWarnings("all")
public class Solution {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        List<Boolean> res = new ArrayList<>(queries.length);

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1] + 1;
            String subStr = s.substring(left, right);
            res.add(isAlindrome(subStr, right - left, queries[i][2]));
        }

        return res;
    }


    private boolean isAlindrome(String str, int len, int k) {
        if (k >= 13) {
            return true;
        }
        if (len == 1 || len / 2 <= k) {
            return true;
        }
        int[] z = new int[26];
        for (int i = 0; i < len; i++) {
            z[str.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (z[i] > 0 && z[i] % 2 != 0) {
                diff++;
            }
        }
        if (diff / 2 <= k) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        String res = JSONObject.toJSONString(solution.canMakePaliQueries(s, queries));
        System.out.println(res);

//        String s = "hunu";
//        int[][] queries = {{1, 1, 1}, {2, 3, 0}, {3, 3, 1}, {0, 3, 2}, {1, 3, 3}, {2, 3, 1}, {3, 3, 1}, {0, 3, 0}, {1, 1, 1}, {2, 3, 0}, {3, 3, 1}, {0, 3, 1}, {1, 1, 1}};
//        String res = JSONObject.toJSONString(solution.canMakePaliQueries(s, queries));
//        System.out.println(res);

    }


}
