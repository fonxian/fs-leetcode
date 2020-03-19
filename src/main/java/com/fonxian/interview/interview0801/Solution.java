package com.fonxian.interview.interview0801;

/**
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 *
 *

 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

 示例1:

 输入：n = 3
 输出：4
 说明: 有四种走法
 示例2:

 输入：n = 5
 输出：13
 提示:

 n范围在[1, 1000000]之间

 status:AC


 * @author Michael Fang
 * @since 2020-03-18
 */
public class Solution {

    public int waysToStep(int n) {
        //dp[n]走到第n阶有几种走法
        // dp[n] = min{dp[n-1]+1,dp[n-2]+1,dp[n-3]+1}
        int[] dp = new int[n+1];

        if(n<=2){
            return n;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4;i<=n;i++){
            int temp = (dp[i-1] + dp[i-2]) % 1000000007;
            dp[i] = (temp + dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }

}
