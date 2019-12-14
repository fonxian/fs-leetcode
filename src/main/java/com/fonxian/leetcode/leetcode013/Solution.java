package com.fonxian.leetcode.leetcode013;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author Michael Fang
 * @since 2019-12-14
 */
public class Solution {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            int temp = map.get(c[i]);
            if (i + 1 < c.length) {
                if (temp < map.get(c[i + 1])) {
                    res += temp * (-1);
                } else {
                    res += temp;
                }
            } else {
                res += temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("LVIII"));
    }

}
