package com.fonxian.leetcode.leetcode169;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author Michael Fang
 * @since 2020-04-01
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int targetCount = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = 1;
            if (map.get(num) == null) {
                map.put(num, count);
            } else {
                count = map.get(num) + 1;
                map.put(num, count);
            }
            if (count > targetCount) {
                return num;
            }
        }
        return -1;
    }

}
