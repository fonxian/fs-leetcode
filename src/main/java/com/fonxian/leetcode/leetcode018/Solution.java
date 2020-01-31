package com.fonxian.leetcode.leetcode018;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/4sum/
 * <p>
 * Status:AC
 * <p>
 * <p>
 * 使用两个循环，外加双指针来解决问题
 *
 * @author Michael Fang
 * @since 2020-01-24
 */
public class Solution {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int h = len - 1;
                while (k < h) {
                    int current = nums[i] + nums[j] + nums[k] + nums[h];
                    if (current > target) {
                        h--;
                    } else if (current < target) {
                        k++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[h]);
                        res.add(list);
                        k++;
                        h--;
                        while (k < h && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    }

                }
            }
        }
        return res;
    }

    /**
     * 错误思路
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSumErrorSolution(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }
        Set<String> resSet = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int location1 = (i + 1) % len;
            int location2 = (i + 2) % len;
            int sum = nums[i] + nums[location1] + nums[location2];
            int find = target - sum;

            for (int j = 0; j < len; j++) {

                if (find == nums[j]
                        && j != i
                        && j != location1
                        && j != location2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[location1]);
                    list.add(nums[location2]);
                    list.add(find);
                    Collections.sort(list);
                    if (!resSet.contains(list.toString())) {
                        resSet.add(list.toString());
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {-3, -1, 0, 2, 4, 5};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        System.out.println(JSONObject.toJSONString(fourSum(nums, target)));

    }
}
