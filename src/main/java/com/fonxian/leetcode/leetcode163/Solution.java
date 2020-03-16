package com.fonxian.leetcode.leetcode163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/missing-ranges/
 * <p>
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * <p>
 * 示例：
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Michael Fang
 * @since 2020-03-15
 */
public class Solution {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        List<String> res = new ArrayList<>();

        for (int i = 0; i <= len; i++) {
            int l = i == 0 ? lower : nums[i - 1];
            int u = i == len ? upper + 1 : nums[i];

        }
        return res;
    }

    public static String getRanges(int lower, int upper) {
        if (upper - lower == 2) {
            return lower + 1 + "";
        }
        if (upper - lower > 2) {
            return String.valueOf(lower + 1) + "->" + String.valueOf(upper - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List res = findMissingRanges(nums, lower, upper);
        res.stream().forEach(System.out::println);
    }

}
