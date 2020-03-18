package com.fonxian.leetcode.leetcode256;

/**
 * https://leetcode-cn.com/problems/paint-house/
 *
 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。

 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。

 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。

 注意：

 所有花费均为正整数。

 示例：

 输入: [[17,2,17],[16,16,5],[14,3,19]]
 输出: 10
 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 最少花费: 2 + 5 + 3 = 10。

 status:AC

 * @author Michael Fang
 * @since 2020-03-18
 */
class Solution {

    public int minCost(int[][] costs) {

        int len = costs.length;
        if(len == 0){
            return 0;
        }
        int[][] dp = new int[len][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1;i<len;i++){
            dp[i][0] =costs[i][0] +  Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] =costs[i][1] +  Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] =costs[i][2] +  Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(
                dp[len-1][0],
                Math.min(dp[len-1][1],dp[len-1][2])
        );
    }
}
