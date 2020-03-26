package com.fonxian.leetcode.leetcode5178;

/**
 * @author Michael Fang
 * @since 2020-03-22
 */
public class Solution {

    static class Cls {
        int num;
        int sum;
        Cls () {
            num = 1;
            sum = 1;
        }
    }

    static Cls [] table = new Cls[100001];
    static {
        for (int i=1; i<= 100000; i++) {
            table[i] = new Cls();
        }
        for (int i=2; i<= 100000; i++) {

            for (int k = i; k<= 100000; k+=i) {
                if (table[k].num <= 4) {
                    table[k].num += 1;
                    table[k].sum += i;
                }
            }
        }
    }

    public int sumFourDivisors(int[] nums) {

        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            if (table[nums[i]].num == 4) {
                sum += table[nums[i]].sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution().sumFourDivisors(new int[]{1,4,21});
    }
}
