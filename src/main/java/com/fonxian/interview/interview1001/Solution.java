package com.fonxian.interview.interview1001;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-20
 */
public class Solution {

    /**
     * 解法1：使用递归
     * 提示超时
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }

    /**
     * 解法2：使用循环
     *
     * status:AC
     * <p>
     * i = 1 1
     * i = 2 1
     * i = 3 2
     * i = 4 3
     * i = 5 5
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        int rst = 0;
        int[] prev = {1, 1};
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            rst = (prev[0] + prev[1]) % 1000000007;
            prev[0] = prev[1];
            prev[1] = rst;
        }
        return rst;
    }


    public static void main(String[] args) {
        System.out.println(fib1(6));
    }

}
