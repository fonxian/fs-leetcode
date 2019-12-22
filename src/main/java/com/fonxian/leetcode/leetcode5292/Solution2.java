package com.fonxian.leetcode.leetcode5292;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Michael Fang
 * @since 2019-12-22
 */
public class Solution2 {

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            queue.offer(nums[i]);
        }
        while (!queue.isEmpty()) {
            int topNum = queue.poll();
            for (int i = 1; i < k; i++) {
                if (!queue.remove(topNum + i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
//        int[] nums = {3, 3, 2, 2, 1, 1};
        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isPossibleDivide(nums,3));
    }


}
