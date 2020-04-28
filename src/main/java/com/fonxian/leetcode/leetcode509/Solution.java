package com.fonxian.leetcode.leetcode509;

/**
 * @author Michael Fang
 * @since 2020-04-12
 */
class Solution {
    public int fib(int N) {
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }
}
