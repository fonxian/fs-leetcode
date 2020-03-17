package com.fonxian.toutiao.toutiao1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 *
 找到所有在 [1, n] 范围之间没有出现在数组中的数字。

 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

 示例:

 输入:
 [4,3,2,7,8,2,3,1]

 输出:
 [5,6]

 *
 * @author Michael Fang
 * @since 2020-03-16
 */
public class Solution {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return rst;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int tmp = nums[nums[i]];
            if (nums[nums[i]] == nums[i]) {
                nums[i] = -1;
            } else {
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(nums));
//        for (int i = 0; i < len; i++) {
//            if (nums[i] == -1) {
//                rst.add(i);
//            }
//        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 2, 3, 1};
        findDisappearedNumbers(nums).forEach(System.out::println);
    }

}