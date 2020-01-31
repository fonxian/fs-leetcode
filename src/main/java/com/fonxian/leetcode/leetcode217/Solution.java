package com.fonxian.leetcode.leetcode217;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * 使用集合来去除重复元素，然后比较集合和数组的大小是否相同。
 *
 * @author Michael Fang
 * @since 2020-01-31
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        return set.size() != len;
    }

}
