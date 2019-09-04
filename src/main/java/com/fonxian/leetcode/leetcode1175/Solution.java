package com.fonxian.leetcode.leetcode1175;

/**
 * 1175. 质数排列
 * <p>
 * https://leetcode-cn.com/problems/prime-arrangements/
 *
 * @author Michael Fang
 * @since 2019-09-01
 */
public class Solution {

    private static final long INF = 1000000007;

    public int numPrimeArrangements(int n) {

        int count = countPrime(n);
        //剩余位数
        int other = n - count;
        long res = 1;
        for (int i = 1; i <= count; i++) {
            res *= i;
            if(res > INF) res%=INF;
        }
        for (int i = 1; i <= other; i++) {
            res *= i;
            if(res > INF) res%=INF;
        }

        return (int) res;
    }


    /**
     * 判断n个数中有多少个质数
     *
     * @param n
     * @return
     */
    private int countPrime(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                ++count;
            }
        }
        return count;
    }

    /**
     * 判断是否是质数
     *
     * @param n
     * @return
     */
    private boolean isPrime(int n) {
        if(n == 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.numPrimeArrangements(5));
    }

}
