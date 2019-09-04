package com.fonxian.leetcode.leetcode5175;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2019-09-04
 * <p>
 * <p>
 * "abcda"
 * [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * dict[0] = a_1
 * ditc[1] = a_1,b_1
 * dict[2] = a_1,b_1,c_1
 * dict[3] = a_1,b_1,c_1,d_1
 * dict[4] = a_2,b_1,c_1,d_1
 */
@SuppressWarnings("all")
public class Solution2 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int len = s.length();
        List<Boolean> res = new ArrayList<>(len);

        int[][] dict = new int[len][26];
        char[] strDict = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                dict[i] = dict[i - 1].clone();
            }
            dict[i][strDict[i] - 'a']++;
        }


        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            int diff = 0;

            for (int j = 0; j < 26; j++) {
                if (left == 0) {
                    if ((dict[right][j] & 1) != 0) {
                        diff++;
                    }
                } else {
                    if (((dict[right][j] - dict[left - 1][j]) & 1) != 0) {
                        diff++;
                    }
                }
            }
            res.add(diff / 2 <= k);
        }
        return res;

    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();

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
