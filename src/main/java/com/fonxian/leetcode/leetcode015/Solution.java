package com.fonxian.leetcode.leetcode015;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 三数之和
 *
 * @author Michael Fang
 * @since 2019-08-08
 */
public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return result;
        }
        int prev = nums[0] + 1;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int left = i + 2;
            int right = len - 1;
            int target = -nums[i];
//            if (nums[i] < prev) {
//                break;
//            }
            while (left < right) {
                int currentValue = nums[left] + nums[right];
                if (currentValue > target) {
                    right--;
                }
                if (currentValue < target) {
                    left++;
                }
                if (currentValue == target) {
//                    prev = nums[i] + 1;
                    prev = nums[i];
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //  -4 -1 -1 0 1 2
        System.out.println(JSON.toJSONString(threeSum(nums)));
    }

}
