package com.fonxian.interview.interview1001;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-20
 */
public class Solution2 {

    public int numWays(int n) {

        if(n == 0){
            return 1;
        }
        if(n <= 2){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }

}
