package com.fonxian.swordoffer.offer45;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-27
 */

public class Solution {

    public String minNumber(int[] nums) {
        StringBuilder rst = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        list.forEach(str -> rst.append(str));
        return rst.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution().minNumber(nums));
    }

}
