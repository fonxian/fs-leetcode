package com.fonxian.leetcode.leetcode88;

import java.util.Arrays;

/**
 * @author Michael Fang
 * @since 2020-04-01
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

}
