package com.fonxian.leetcode.leetcode162;

/**
 * @author Michael Fang
 * @since 2020-03-29
 */
public class Solution {

    /**
     * 解法一：算法复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        int rst = nums[0];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (len == 1) {
                    return i;
                }
                continue;
            }
            if (i == len - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 解法二：O（n）简化代码
     *
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return len - 1;
    }

    /**
     * 解法三：O(logN) 使用二分法
     *
     * @param nums
     * @return
     */
    public int findPeakElement3(int[] nums) {
        return search(nums,0,nums.length-1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        // 1 2 3 4 5 6
        // 0 1 2 3 4 5
        int mid = (r + l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums,l,mid);
        }
        return search(nums, mid+1, r);
    }


}
