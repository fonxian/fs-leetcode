package com.fonxian.leetcode.leetcode5175;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2019-09-04
 */
@SuppressWarnings("all")
public class Solution3 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        int len = s.length();
        List<Boolean> res = new ArrayList<>(len);

        int[] bitArray = new int[len];
        char[] strDict = s.toCharArray();
        for (int i = 0; i < len; i++) {
            bitArray[i] = 1 << (strDict[i] - 'a');
            if (i > 0) {
                bitArray[i] ^= bitArray[i - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            //子串各个位之和
            int sum = 0;
            if (left == 0) {
                sum = bitArray[right];
            } else {
                sum = bitArray[right] ^ bitArray[left - 1];
            }
            //计算子串的位中有多少个1
            int count = 0;
            //k <= count/2  等价于 2*k + 1 <= count
            k = 2 * k + 1;
            boolean ok = true;
            while (sum != 0) {
                sum &= (sum - 1);
                count++;
                if (count > k) {
                    ok = false;
                    break;
                }
            }
            res.add(ok);
        }

        return res;
    }

}