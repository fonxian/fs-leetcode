package com.fonxian.leetcode.leetcode5279;

/**
 * @author Michael Fang
 * @since 2019-12-08
 */
public class Solution {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;
        int temp = n;
        while (temp != 0) {
            int x = temp % 10;
            temp = temp / 10;
            sum += x;
            mul *= x;
        }
        return mul - sum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subtractProductAndSum(234));
    }

}
