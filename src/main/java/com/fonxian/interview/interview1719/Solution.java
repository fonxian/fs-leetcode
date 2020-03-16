package com.fonxian.interview.interview1719;

import java.util.Arrays;

/**
 * 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * 输入: [1]
 * 输出: [2,3]
 * <p>
 * 示例 2:
 * 输入: [2,3]
 * 输出: [1,4]
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-16
 */
public class Solution {

    public static int[] missingTwo(int[] nums) {

        int len = nums.length;
        int[] newArray = new int[len + 3];
        int[] rst = new int[2];
        for (int i = 0; i < len; i++) {
            newArray[nums[i]] = 1;
        }
        for (int i = 1; i <= len + 2; i++) {
            if (newArray[i] == 0) {
                if (rst[0] != 0) {
                    rst[1] = i;
                } else {
                    rst[0] = i;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3};
//        int[] nums = {1, 2, 3, 6, 7};
//        int[] nums = {1, 4};
//        System.out.println(Arrays.toString(missingTwo(nums)));

        int[] nums = {8, 2, 3, 6, 7};
        Arrays.sort(nums);
        int[] test = Arrays.copyOf(nums,2);
        System.out.println(Arrays.toString(test));
    }

}
