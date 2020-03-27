package com.fonxian.swordoffer.offer03;

import java.util.Arrays;

/**
 *
 * 面试题03. 数组中重复的数字
 *
 找出数组中重复的数字。

 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 输入：
 [2, 3, 1, 0, 2, 5, 3]
 输出：2 或 3

 *
 * status:AC
 *
 *
 * @author Michael Fang
 * @since 2020-03-16
 */
public class Solution {

    /**
     * 解法一：开辟新的数组空间
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return -1;
        }
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            if (tmp[nums[i]] == 0) {
                tmp[nums[i]] += 1;
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 解法二：排序
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return -1;
        }
        Arrays.sort(nums);
        for(int i = 0;i<len;i++){
            if(i-1>0 && nums[i] == nums[i-1]){
                return nums[i];
            }
            if(i+1<len && nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 解法三：时间和空间复杂度最优 O(n)、O(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        // 2 3 1 0 2
        // 1 3 2 0 2
        // 3 1 2 0 2
        // 0 1 2 3 2 (nums[i] == i)
        // 0 1 2 3 2(cur)  (nums[i] == nums[nums[i]])
        for(int i = 0;i<len;i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums,int i,int num){
        int t = nums[num];
        nums[num] = nums[i];
        nums[i] = nums[num];
    }



    public static void main(String[] args) {

    }

}
