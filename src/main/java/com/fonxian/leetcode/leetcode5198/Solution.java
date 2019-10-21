package com.fonxian.leetcode.leetcode5198;

/**
 * @author Michael Fang
 * @since 2019-09-22
 */
public class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {
        long res = 0;
        long indexA = 1, indexB = 1, indexC = 1;
        for (int i = 1; i <=n; i++) {
            long tmp = indexA * a < indexB * b ? indexA * a : indexB * b;
            res = indexC * c < tmp ? indexC * c : tmp;
            if (res == indexA * a) {
                indexA++;
            }
            if (res == indexB * b) {
                indexB++;
            }
            if (res == indexC * c) {
                indexC++;
            }
        }

        return (int) res;
    }

    public int getN(int n) {
        return nthUglyNumber(n, 2, 3, 5);
    }

    /**
     * 判断丑数
     *
     * @param num
     * @param a
     * @param b
     * @param c
     * @return
     */
    private boolean judgeUglyNum(int num, int a, int b, int c) {
        if (num % a == 0 || num % b == 0 || num % c == 0) {
            return true;
        }
        while (num % a == 0) {
            num /= a;
        }
        while (num % b == 0) {
            num /= b;
        }
        while (num % c == 0) {
            num /= c;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(3, 2, 3, 5));
        System.out.println(solution.nthUglyNumber(4, 2, 3, 4));
        System.out.println(solution.nthUglyNumber(5, 2, 11, 13));
        System.out.println(solution.nthUglyNumber(1000000000, 2, 217983653, 336916467));
        System.out.println(solution.nthUglyNumber(28, 9, 21, 26));
//        System.out.println(solution.getN(1));
    }

}
