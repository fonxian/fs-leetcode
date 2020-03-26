package com.fonxian.swordoffer.offer50;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/submissions/
 *
 * @author Michael Fang
 * @since 2020-03-27
 */
public class Solution {

    public char firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]).intValue() + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("abaccdeff"));
    }

}
