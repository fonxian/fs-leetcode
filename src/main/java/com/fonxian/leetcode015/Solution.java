package com.fonxian.leetcode015;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 三数之和
 *
 * @author Michael Fang
 * @since 2019-08-08
 */
public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[j], j);
            }
            for (int k = i + 1; k < nums.length; k++) {
                if (map.containsKey(target - nums[k])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[k]);
                    list.add(map.get(target - nums[k]));
                    result.add(list);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(JSON.toJSONString(threeSum(nums)));
    }

}
