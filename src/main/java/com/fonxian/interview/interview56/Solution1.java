package com.fonxian.interview.interview56;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-20
 */
public class Solution1 {

    /**
     * 解法1：使用哈希表
     *
     * status:AC
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 解法2：排序
     *
     * status：AC
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) {
            return -1;
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber(nums));
    }

}
