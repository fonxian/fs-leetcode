package com.fonxian.leetcode.leetcode5381;

import java.util.Arrays;

/**
 * @author Michael Fang
 * @since 2020-04-12
 */
public class Solution {

    public int[] processQueries(int[] queries, int m) {
        int queriesLength = queries.length;
        int pLength = m;
        int[] p = new int[pLength];
        int[] res = new int[queriesLength];
        for (int i = 0; i < m; i++) {
            p[i] = i + 1;
        }
        for (int i = 0; i < queriesLength; i++) {
            int target = queries[i];
            for (int x = 0; x < pLength; x++) {
                if (p[x] == target) {
                    res[i] = x;
                    break;
                }
            }
            for (int j = res[i]; j >= 1; j--) {
                p[j] = p[j - 1];
            }
            p[0] = queries[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] queries = {7, 5, 5, 8, 3};
        int m = 8;
        System.out.println(Arrays.toString(new Solution().processQueries(queries, m)));
    }

}
