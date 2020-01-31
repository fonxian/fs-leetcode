package com.fonxian.leetcode.leetcode015;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 三数之和
 *
 * status:AC
 *
 * 使用三层循环会超时，还要想办法解决重复的问题
 *
 * 使用一个循环，外加双指针来解决该问题
 *
 * @author Michael Fang
 * @since 2019-08-08
 */
public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            // 可以防止 -1 -1 -1 0 1 2这种情况的重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int h = len - 1;
            while (l < h) {
                int target = nums[i] + nums[l] + nums[h];
                if (target > 0) {
                    h--;
                } else if (target < 0) {
                    l++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[h]);
                    res.add(list);
                    h--;
                    l++;
                    // 可以防止[-2,0,0,2,2]这种情况的重复
                    while(l<h && nums[l] == nums[l-1]){
                        l++;
                    }
                    while(l<h && nums[h] == nums[h+1]){
                        h--;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSumError(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> resSet = new HashSet<>();
        int len = nums.length;
        if (len < 3) {
            return result;
        }

        int min = nums[0] + nums[1] + nums[2];
        int max = nums[len - 1] + nums[len - 2] + nums[len - 3];
        if (max < 0 || min > 0) {
            return result;
        }

        for (int i = 0; i < len - 2; i++) {
            OK:
            for (int j = i + 1; j < len - 1; j++) {
                int k = j + 1;
                while (k < len) {
                    int current = nums[i] + nums[j] + nums[k];
                    if (current == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        if (!resSet.contains(list.toString())) {
                            resSet.add(list.toString());
                            result.add(list);
                        }
                        continue OK;
                    }
                    k++;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        //  -4 -1 -1 0 1 2
        int[] nums = {-2,0,0,2,2};
        System.out.println(JSON.toJSONString(threeSum(nums)));
    }

}
